package pong_game_no_networking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Pong implements ActionListener, Runnable, MouseMotionListener {

    public static Pong pong;
    int width =1000, height = 600;
    public Renderer renderer;

    public Paddle player1;
    public Paddle player2;
    public Puck puck;
    final int initVelocity = 9;

    public Pong() {

	JFrame jframe = new JFrame("My Pong Game");
	renderer = new Renderer();
	renderer.addMouseMotionListener(this);

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
	puck = new Puck(this, 30, initVelocity);
    }

    public void render(Graphics g) {

	g.setColor(Color.BLACK);
	g.fillRect(0, 0, width, height);

	player1.render(g);
	player2.render(g);
	puck.render(g);
    }

    void update() {
	boolean playerHit = false;
	// normal x behavior
	if(puck.x + puck.size <= 0) {
	    puck.xVelocity = Math.abs(puck.xVelocity);
	} else if(puck.x + puck.size >= width) {
	    puck.xVelocity = -puck.xVelocity;
	}

	// normal y behavior
	if(puck.y + puck.size <= 0) {
	    puck.yVelocity = Math.abs(puck.yVelocity);
	} else if(puck.y + puck.size >= height) {
	    puck.yVelocity = -puck.yVelocity;
	}

        
        // normal paddle behavior
        
	// left side player
        if(puck.x <= player1.x) {
            if(puck.y >= player1.y && puck.y <= player1.y + player1.height - 1) {
        	puck.xVelocity = Math.abs(puck.xVelocity); // make it go faster for a second
        	playerHit = true;
            } else {
        	System.out.println("In the hole");
            }
        }
        // right side player
        if(puck.x >= player2.x - player2.width) {
            if(puck.y >= player2.y && puck.y <= player2.y + player2.height - 1) {
        	puck.xVelocity = puck.xVelocity; 
        	playerHit = true;
            }
        }
        if (playerHit) {
            puck.y += puck.yVelocity*2; // make it go faster
            puck.x += puck.xVelocity;
        } else {
            puck.y += puck.yVelocity;
            puck.x += puck.xVelocity;
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
	int mouseY = e.getY();
	int mouseX = e.getX();
	player1.y = mouseY - player1.height/2;
    }



}
