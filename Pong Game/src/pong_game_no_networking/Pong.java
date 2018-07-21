package pong_game_no_networking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Pong implements ActionListener, Runnable {

    public static Pong pong;
    int width =1000, height = 600;
    public Renderer renderer;

    public Paddle player1;
    public Paddle player2;
    public Puck puck;

    public Pong() {

	JFrame jframe = new JFrame("My Pong Game");
	renderer = new Renderer();

	jframe.setSize(width + 15, height);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.add(renderer);	

	start();
	jframe.setVisible(true);
	
	Thread th = new Thread(this);
	th.start();
    }

    public void start() {
	player1 = new Paddle(this,1);
	player2 = new Paddle(this,2);
	puck = new Puck(this, 30, 8);
    }

    public void render(Graphics g) {

	g.setColor(Color.BLACK);
	g.fillRect(0, 0, width, height);

	player1.render(g);
	player2.render(g);
	puck.render(g);
    }

    void update() {
	// normal x behavior
	if(puck.x + puck.size <= 0) {
	    puck.xVelocity = Math.abs(puck.xVelocity);
	} else if(puck.x + puck.size >= width) {
	    puck.xVelocity = -puck.xVelocity;
	    System.out.println("hit puck.x >= width");
	}

	// normal y behavior
	if(puck.y + puck.size <= 0) {
	    puck.yVelocity = Math.abs(puck.yVelocity);
	} else if(puck.y + puck.size >= height) {
	    puck.yVelocity = -puck.yVelocity;
	}

        puck.y += puck.yVelocity;
        puck.x += puck.xVelocity;
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
	update();
	renderer.repaint();

    }
    public static void main(String[] args) {
	pong = new Pong();

    }

    @Override
    public void run() {
	while(true) {
	    try {
		Thread.sleep(30);
		update();
		renderer.repaint();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	// TODO Auto-generated method stub
	
    }



}
