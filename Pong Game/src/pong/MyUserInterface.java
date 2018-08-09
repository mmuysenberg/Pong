package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import gameNet.GameNet_UserInterface;
import gameNet.GamePlayer;

public class MyUserInterface extends JPanel implements GameNet_UserInterface {

    Box box = null;
    Image offScreenImage = null;
    Dimension previousSize = null;

    GamePlayer myGamePlayer;
    String myName;
    MyGameInput myGameInput = new MyGameInput();
    int game_top, game_bottom, game_left, game_right;
    Color[] paddleColors = { Color.green, Color.red };
    BoardDimensions boardDimensions = new BoardDimensions();

    // final String GAME_PANEL = "GAME";
    // final String SETUP_PANEL = "SETUP";
    @Override
    public void receivedMessage(Object ob) {
	MyGameOutput myGameOutput = (MyGameOutput) ob;
	// Check to see we were accepted and connected
	if (myGamePlayer != null) {
	    if (myGameOutput.myGame.getMyIndex(myName) > 1) {
		System.out.println("Not allowed to connect to the game");
		exitProgram();
	    } else {
		box = myGameOutput.myGame.box;
		repaint();
	    }
	} else
	    System.out.println("Getting outputs before we are ready");
    }

    @Override
    public void startUserInterface(GamePlayer player) {
	myGamePlayer = player;
	myName = myGamePlayer.getPlayerName();
	myGameInput.setName(myName);
	myGameInput.setCmd(MyGameInput.CONNECTING);
	myGamePlayer.sendMessage(myGameInput);
    }

    public MyUserInterface() {
	super();
	setSize(800, 400);
	Mouser m = new Mouser();
	addMouseMotionListener(m);
	addMouseListener(m);
	setVisible(true);
    }

    public void paint(Graphics theScreen) {
	Dimension d = getSize();
	if (offScreenImage == null || !d.equals(previousSize)) {
	    offScreenImage = createImage(d.width, d.height);
	    previousSize = d;
	}
	Graphics2D g = (Graphics2D) offScreenImage.getGraphics();
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g.setFont(new Font("Terminal", Font.BOLD, 35));

	g.setColor(Color.BLACK);
	g.fillRect(0, 0, d.width, d.height);
	g.setColor(Color.WHITE);

	Insets insets = getInsets();
	int pad = 10;
	boardDimensions.setParms(insets.top, insets.left + pad, d.width - insets.left - insets.right - 2 * pad,
		d.height - insets.top - insets.bottom - 2 * 0);
	if (box == null) {
	    g.drawString("Click Mouse to start", 100, 100);
	} else {

	    ArrayList<String> names = box.getClientNames();
            String str = "";
	    if (!box.isRunning() && !box.isEnd()) {
		g.setFont(new Font("Terminal", Font.BOLD, 25));
		str = "Click Mouse to play";
		g.drawString(str, (getWidth() - g.getFontMetrics().stringWidth(str)) / 2, 200);
		g.setFont(new Font("Terminal", Font.BOLD, 35));
	    } 
//	    System.out.println(box.isEnd() + " " +box.highestScore);
	    if (box.isEnd()) {
		g.setFont(new Font("Terminal", Font.BOLD, 35));
		FontMetrics largeFontMetrics = g.getFontMetrics();
		str = myGamePlayer.getPlayerName(); 
		if(str.equals(box.whoWon()))
                     str += " Won!!";
		else
		    str += " Lost!!";
		g.drawString(str, (getWidth() - g.getFontMetrics().stringWidth(str)) / 2, 200);
		g.setFont(new Font("Terminal", Font.BOLD, 25));
		str = "click to reset game.";
		g.drawString(str, (getWidth() - g.getFontMetrics().stringWidth(str)) / 2, 200 + largeFontMetrics.getHeight());
		g.setFont(new Font("Terminal", Font.BOLD, 35));
	    }
	    // when score too high

	    Point bur = boardDimensions.toPixels(box.boxUpperRight);
	    Point bul = boardDimensions.toPixels(box.boxUpperLeft);

	    Point blr = boardDimensions.toPixels(box.boxLowerRight);
	    Point bll = boardDimensions.toPixels(box.boxLowerLeft);
	    Point hu = boardDimensions.toPixels(box.rightHoleUpper);
	    Point hl = boardDimensions.toPixels(box.rightHoleLower);

	    Point lefthu = boardDimensions.toPixels(box.leftHoleUpper);
	    Point lefthl = boardDimensions.toPixels(box.leftHoleLower);

	    // g.drawLine(bll.x, bll.y, blr.x, blr.y); // lower line
	    // g.drawLine(bul.x,bul.y, bur.x, bur.y); // top side
	    // g.drawLine(bur.x, bur.y, hu.x, hu.y); // above hole on right
	    // g.drawLine(blr.x, blr.y, hl.x, hl.y); // below hole on right

	    // g.drawLine(bul.x, bul.y, lefthu.x, lefthu.y); // above hole on left
	    // g.drawLine(bll.x, bll.y, lefthl.x, lefthl.y); // below hole on right

	    Point pball = boardDimensions.toPixels(box.ballLoc);
	    int r = boardDimensions.toPixels(box.ballRadius);
	    g.fillOval(pball.x - r, pball.y - r, 2 * r, 2 * r);

	    int paddleWidth = boardDimensions.toPixels(box.paddleWidth);

	    for (int i = 0; i < 2; i++) {
		Point pPaddle = boardDimensions.toPixels(box.paddleLoc[i]);
		if (i == 0)
		    g.fillRect(pPaddle.x - 8, pPaddle.y, 8, paddleWidth);
		else
		    g.fillRect(pPaddle.x, pPaddle.y, 8, paddleWidth);
	    }

	    FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
	    int fontSize =  g.getFont().getSize();

	    Point leftScorePoint = boardDimensions.toPixels(box.leftScorePoint);
	    Point rightScorePoint = boardDimensions.toPixels(box.rightScorePoint);

	    Point rightNameLocation = boardDimensions.toPixels(box.rightNameLocation);
	    Point leftNameLocation = boardDimensions.toPixels(box.leftNameLocation);
	    int nameXMargin = 20;

	    String leftName = "Unkown";
	    String rightName = names.get(0);
	    if(names.size() > 1) 
                leftName = names.get(1);
	    
	    String leftScore = Integer.toString(box.successCount[1]);
	    String rightScore = Integer.toString(box.successCount[0]);
	    
	    // left score
	    g.drawString(leftScore,
		    leftScorePoint.x + fontMetrics.stringWidth(leftName) + nameXMargin*2,
		    leftScorePoint.y + fontSize);
	    // left name
	    System.out.println(leftNameLocation);
	    g.drawString(leftName, leftNameLocation.x + nameXMargin , leftNameLocation.y +fontSize);
	    //right name
	    g.drawString(rightName, rightNameLocation.x - fontMetrics.stringWidth(rightName) - nameXMargin, rightNameLocation.y + fontSize);
	    // right score
	    g.drawString(rightScore,
		    rightScorePoint.x - fontMetrics.stringWidth(rightName) - (nameXMargin*3),
		    rightScorePoint.y + fontSize);

	}

	theScreen.drawImage(offScreenImage, 0, 0, this);
    }

    void exitProgram() {
	if (myGamePlayer != null) {
	    myGameInput.setCmd(MyGameInput.DISCONNECTING);
	    myGamePlayer.sendMessage(myGameInput); // Let the game know that we are leaving

	    myGamePlayer.doneWithGame(); // clean up sockets
	}
	System.exit(0);
    }

    // *******************************************
    // An Inner class
    // *******************************************
    class Mouser extends MouseAdapter {
	public void mouseMoved(MouseEvent e) {
	    int y = e.getY();

	    if (box != null) {
		myGameInput.setLocation(boardDimensions.toGenericY(y));
		if (myGamePlayer != null)
		    myGamePlayer.sendMessage(myGameInput);

	    }

	}

	public void mousePressed(MouseEvent e) {
	    myGameInput.setCmd(MyGameInput.MOUSE_PRESSED);
	    if (myGamePlayer != null)
		myGamePlayer.sendMessage(myGameInput);

	}

    }

    // *******************************************
    // Another Inner class
    // *******************************************
    // class Termination extends WindowAdapter {
    // public void windowClosing(WindowEvent e) {
    // System.out.println("Client is exitting game");
    // exitProgram();
    // }
    // }

    // ****** Done with Inner Classes ***************
}
