package pong_game_no_networking;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	
	int paddleNumber;
	int x, y, width = 25, height = 200;
	
	Score score;
	
	class Score {
	    private int wins;
	    private int losses;
	    
	    Score() {
		wins = 0;
		losses = 0;
	    }
	    public void addWin() {
		wins++;
	    }
	    public void addLoss() {
		losses++;
	    }
	    
	    public int getWins() {
		return wins;
	    }
	    public int getLosses() {
		return losses;
	    }
	}
	
	
	public Paddle(Pong pong,int paddleNumber) {
		
		this.paddleNumber = paddleNumber;
		
		if(paddleNumber == 1) {
			this.x = 0;
		}
		else if(paddleNumber ==2) {
			this.x = pong.width-width;
		}
		
		this.y = pong.height / 2 - this.height / 2;
		score = new Score();
	}


	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		
	}

}

