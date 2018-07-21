package pong_game_no_networking;

import java.awt.Color;
import java.awt.Graphics;

public class Puck {
    int x, y, size;
    int xVelocity;
    int yVelocity;
    
    public Puck(Pong pong, int size, int initVelocity) {
	this.xVelocity = initVelocity;
	this.yVelocity = initVelocity;
	this.size = size;
	y = pong.height /2 - size/2;
	x = pong.width / 2 - size/2;
	
    }
    
    
    public void render(Graphics g) {
	g.setColor(Color.RED);
	g.fillOval(x, y, size, size);
	g.setColor(Color.black);
    }
}
