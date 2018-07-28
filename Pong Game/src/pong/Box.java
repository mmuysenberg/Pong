package pong;

import java.awt.Point;
import java.io.Serializable;
import java.util.Random;

public class Box implements Serializable {

    // generic size
    static final int box_width = 1000;
    static final int box_height = 500;

    Point boxUpperRight;
    Point boxUpperLeft;
    Point boxLowerRight;
    Point boxLowerLeft;

    Point rightHoleUpper;
    Point rightHoleLower;

    Point leftHoleUpper;
    Point leftHoleLower;
    int paddleHeight;
    int yAngle;

    Point ballLoc;

    Point[] paddleLoc;
    int[] prevPaddleY = new int[2];

    int paddleWidth;
    int ballRadius = 20;
    private int ballVx, ballVy;

    int[] successCount = new int[2];
    private boolean running = false;
    int whichPaddle;
    Random randomGen = new Random();

    public boolean isRunning() {
	return running;
    }

    public Box() {
	int box_top = 0;
	int box_bottom = box_height;
	int box_left = 0;
	int box_right = box_width;
	paddleHeight = 8;
	whichPaddle = 0;

	boxUpperRight = new Point(box_right, box_top);
	boxUpperLeft = new Point(box_left, box_top);
	boxLowerRight = new Point(box_right, box_bottom);
	boxLowerLeft = new Point(box_left, box_bottom);
	rightHoleUpper = new Point(box_right, box_top + (box_bottom - box_top) / 4);
	rightHoleLower = new Point(box_right, box_top + 3 * (box_bottom - box_top) / 4);

	leftHoleUpper = new Point(box_left, box_top + (box_bottom - box_top) / 4);
	leftHoleLower = new Point(box_left, box_top + 3 * (box_bottom - box_top) / 4);
	paddleWidth = 90;
	
	paddleLoc = new Point[2];
	setGame(false);

    }

    void setGame(boolean startRunning) {
	int box_top = 0;
	int box_bottom = box_height;
	int box_left = 0;
	int box_right = box_width;

	// Start the ball out at a random spot
	// Heuristic for generating random starting velocities ... maybe not the best
	
	// randomly choose to go to the top or bottom or center

//	var initialSpeedX = 5;
//	var initialSpeedY = -6;  
//	ballVx = -randomizer(4, 8);
//	if(randomizer(1, 2) == 1)
//            ballVy = randomizer(4, 8);
//        else
//            ballVy = -randomizer(4, 8);

	if(paddleLoc[0] == null)
            paddleLoc[0] = new Point(box_right, ( rightHoleUpper.y+rightHoleLower.y)/2);
	else
            paddleLoc[0] = new Point(box_right, paddleLoc[0].y);
	if(paddleLoc[1] == null)
            paddleLoc[1] = new Point(box_left + 1, ( rightHoleUpper.y+rightHoleLower.y)/2);
	else
            paddleLoc[1] = new Point(box_left + 1, paddleLoc[1].y);

	if (whichPaddle == 1) {
            ballVx = randomizer(-20, -10);
            ballLoc = new Point(paddleLoc[1].x + ballRadius + paddleHeight, paddleLoc[1].y +paddleWidth/2);
	} else {
            ballVx = randomizer(10, 20);
            ballLoc = new Point(paddleLoc[0].x - ballRadius, paddleLoc[0].y +paddleWidth/2);
	}
        ballVy = 0;
	System.out.println(ballVx + " " + ballVy);
	if (startRunning)
	    running = true;
    }

    public void setPaddleY(int yLoc, int clientIndex) {
	paddleLoc[clientIndex].y = yLoc - paddleWidth/2;
	if(running == false) {
	    if (whichPaddle == 0) {
	            ballLoc = new Point(paddleLoc[0].x - ballRadius, paddleLoc[0].y +paddleWidth/2);
		} else {
	            ballLoc = new Point(paddleLoc[1].x + ballRadius + paddleHeight, paddleLoc[1].y +paddleWidth/2);
		}
	}

	if(prevPaddleY[clientIndex] != paddleLoc[clientIndex].y) {
            if(paddleLoc[clientIndex].y + 1 < prevPaddleY[clientIndex]) {
                yAngle = 1;
            } else if(paddleLoc[clientIndex].y + 1 > prevPaddleY[clientIndex]) {
                yAngle = -1;
            } else {
                yAngle = 0;
            }
	}
            System.out.println("curr pos: " + paddleLoc[clientIndex].y + "; prev pos: "  + prevPaddleY[clientIndex]); 
        prevPaddleY[clientIndex] = paddleLoc[clientIndex].y;
    }
    
    int randomizer(int min, int max) {
	if (min > max) {
            throw new IllegalArgumentException("Min " + min + " greater than max " + max);
        }

        return (int) ( (long) min + Math.random() * ((long)max - min + 1));
    }

    public void update() {
	if (!running)
	    return;
        boolean paddleHit = false;

	// right paddle
	if (ballLoc.x + ballRadius > boxUpperRight.x) // if ball x is >= right x
	{
	    if (ballLoc.y >= paddleLoc[0].y && // if ball y is paddle yish
		    ballLoc.y <= paddleLoc[0].y + paddleWidth) {
		successCount[0]++;
		if(yAngle == -1)
		    ballVy = 16;
		else if(yAngle == 1)
		    ballVy = -16;
		else if(yAngle == 0)
		    ballVy = 0;
		ballVx *= -1;
		paddleHit = true;
		System.out.println("In Hole and hits paddle");
	    } else { // created one giant hole
		System.out.println("In Hole and hits paddle");
		whichPaddle = 0;
		running = false;
		System.out.println("In Hole and missed by paddle");
	    }
	}
	// left paddle
	if (ballLoc.x - ballRadius < boxUpperLeft.x) {
	//if(ballLoc.x - ballRadius <= boxUpperLeft.x + paddleHeight) { // test tomorrow
	    if (ballLoc.y >= paddleLoc[1].y && ballLoc.y <= paddleLoc[1].y + paddleWidth) {
		successCount[1]++; // In hole but bounces off left paddle
		if(yAngle == -1)
		    ballVy = 16;
		else if(yAngle == 1)
		    ballVy = -16;
		else if(yAngle == 0)
		    ballVy = 0;
		ballVx *= -1;
		System.out.println("In Hole and hits paddle");
		paddleHit = true;
	    } else {
		// In hole and missed by paddle
//		ballLoc.x = boxUpperLeft.x + ballRadius;
		whichPaddle = 1;
		running = false;
		System.out.println("In Hole and missed by paddle");
	    }
	}

	// check against the top and bottom wall
	if (ballLoc.x + ballRadius <= boxUpperRight.x || ballLoc.x + ballRadius >= boxUpperLeft.x) // if ball x < right x
												 // || ball x > left x
	{
	    if (ballLoc.y + ballRadius>= boxLowerRight.y) { // if ball y >= bottom y
		ballVy *= -1;
	    } else if (ballLoc.y - ballRadius<= boxUpperRight.y) { // else if ball y <= top y
		ballVy *= -1;
	    }

	}
	if(paddleHit) {
            ballLoc.x = ballLoc.x + ballVx + ballVx;
            ballLoc.y = ballLoc.y + ballVy;
	} else {
            ballLoc.x = ballLoc.x + ballVx;
            ballLoc.y = ballLoc.y + ballVy;
	}

    }

}
