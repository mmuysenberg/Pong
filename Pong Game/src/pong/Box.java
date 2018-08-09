package pong;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.bind.SchemaOutputResolver;

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

    int ballRadius = 20;
    private int ballVx, ballVy;

    int paddleWidth;
    private boolean running = false;
    int whichPaddle;
    int paddleHitBallXSpeed;
    Random randomGen = new Random();
    ArrayList<String> clients = new ArrayList<>();

    Point leftScorePoint;
    Point rightScorePoint;
    Point leftNameLocation;
    Point rightNameLocation;
    int[] successCount = new int[2];
    boolean lost[] = { false, false };
    // int highestScore = 0;

    public boolean isRunning() {
	return running;
    }

    public void resetGame() {
    }

    public boolean isEnd() {
	int highestScore = 0;
	int maxScore = 5;
	for (int score : successCount) {
	    if (score > highestScore) {
		highestScore = score;
	    }
	}
	if (highestScore >= maxScore) {
//	    successCount[0] = 0;
//	    successCount[1] = 0;
	    return true;
	}
	else
	    return false;
    }

    public String whoWon() {
	if (isEnd()) {
	    if (clients.isEmpty())
		return null;
	    else if (clients.size() <= 1)
		return clients.get(0);
	    else {
		int highestScore = 0;
		for (int i = 0; i < clients.size(); i++) {
		    if (successCount[i] >= highestScore)
			highestScore = successCount[i];
		}
		for (int i = 0; i < clients.size(); i++) {
		    if (successCount[i] == highestScore)
			return clients.get(i);
		}
	    }
	    return null;
	} else {
	    return null;
	}
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
	leftScorePoint = new Point(box_left, box_top);
	rightScorePoint = new Point(box_right, box_top);
	leftNameLocation = new Point(box_left, box_top);
	rightNameLocation = new Point(box_right, box_top);

	paddleLoc = new Point[2];
	setGame(false);
    }

    void setGame(boolean startRunning) {
	if(isEnd()) {
	    successCount = new int[2];
	}
	int box_top = 0;
	int box_bottom = box_height;
	int box_left = 0;
	int box_right = box_width;
	paddleHitBallXSpeed = 0;

	if (paddleLoc[0] == null)
	    paddleLoc[0] = new Point(box_right, (rightHoleUpper.y + rightHoleLower.y) / 2);
	else
	    paddleLoc[0] = new Point(box_right, paddleLoc[0].y);
	if (paddleLoc[1] == null)
	    paddleLoc[1] = new Point(box_left + 1, (rightHoleUpper.y + rightHoleLower.y) / 2);
	else
	    paddleLoc[1] = new Point(box_left + 1, paddleLoc[1].y);

	if (whichPaddle == 1) {
	    ballVx = randomizer(-20, -10);
	    ballLoc = new Point(paddleLoc[1].x + ballRadius + paddleHeight, paddleLoc[1].y + paddleWidth / 2);
	} else {
	    ballVx = randomizer(10, 20);
	    ballLoc = new Point(paddleLoc[0].x - ballRadius - paddleHeight, paddleLoc[0].y + paddleWidth / 2);
	}
	ballVy = 0;
	System.out.println(ballVx + " " + ballVy);
	if (startRunning)
	    running = true;
    }

    public void setPaddleY(int yLoc, int clientIndex) {
	paddleLoc[clientIndex].y = yLoc - paddleWidth / 2;
	if (running == false) {
	    if (whichPaddle == 0) {
		ballLoc = new Point(paddleLoc[0].x - ballRadius - paddleHeight, paddleLoc[0].y + paddleWidth / 2);
	    } else {
		ballLoc = new Point(paddleLoc[1].x + ballRadius + paddleHeight, paddleLoc[1].y + paddleWidth / 2);
	    }
	}

	if (prevPaddleY[clientIndex] != paddleLoc[clientIndex].y) {
	    if (paddleLoc[clientIndex].y + 1 < prevPaddleY[clientIndex]) {
		yAngle = 1;
	    } else if (paddleLoc[clientIndex].y + 1 > prevPaddleY[clientIndex]) {
		yAngle = -1;
	    } else {
		yAngle = 0;
	    }
	}
	prevPaddleY[clientIndex] = paddleLoc[clientIndex].y;
    }

    int randomizer(int min, int max) {
	if (min > max) {
	    throw new IllegalArgumentException("Min " + min + " greater than max " + max);
	}

	return (int) ((long) min + Math.random() * ((long) max - min + 1));
    }

    public void update() {
	if (!running)
	    return;
	boolean paddleHit = false;

	// right paddle
	if (ballLoc.x + ballRadius + ballVx > boxUpperRight.x) // if ball x is >= right x
	{
	    if (ballLoc.x >= paddleLoc[0].x - ballRadius - paddleHeight * 2 && ballLoc.y >= paddleLoc[0].y && // if ball
													      // y is
													      // paddle
													      // yish
		    ballLoc.y <= paddleLoc[0].y + paddleWidth) {
		if (yAngle == -1)
		    ballVy = randomizer(5, 16);
		else if (yAngle == 1)
		    ballVy = randomizer(-16, -5);
		else if (yAngle == 0)
		    ballVy = 0;
		paddleHit = true;
		ballVx *= -1;
	    } else { // created one giant hole
		ballVx *= -1;
		successCount[1]++;
		whichPaddle = 1;
		running = false;
	    }
	}
	// left paddle
	if (ballLoc.x - ballRadius + ballVx < boxUpperLeft.x) {
	    // if(ballLoc.x - ballRadius <= boxUpperLeft.x - paddleHeight) { // test
	    // tomorrow
	    if (ballLoc.x <= paddleLoc[1].x + ballRadius + paddleHeight * 2 && ballLoc.y >= paddleLoc[1].y
		    && ballLoc.y <= paddleLoc[1].y + paddleWidth) {
		if (yAngle == -1)
		    ballVy = randomizer(5, 16);
		else if (yAngle == 1)
		    ballVy = randomizer(-16, -5);

		else if (yAngle == 0)
		    ballVy = 0;
		ballVx *= -1;
		paddleHit = true;
	    } else {
		successCount[0]++; // In hole but bounces off left paddle
		// In hole and missed by paddle
		// ballLoc.x = boxUpperLeft.x + ballRadius;
		ballVx *= -1;
		whichPaddle = 0;
		running = false;
	    }

	}

	// check against the top and bottom wall
	if (ballLoc.x + ballRadius <= boxUpperRight.x || ballLoc.x + ballRadius >= boxUpperLeft.x) // if ball x < right
												   // x
	// || ball x > left x
	{
	    if (ballLoc.y + ballRadius + ballVy >= boxLowerRight.y) { // if ball y >= bottom y
		ballVy *= -1;
		// ballLoc.y = boxLowerRight.y - ballRadius;
	    } else if (ballLoc.y - ballRadius + ballVy <= boxUpperRight.y) { // else if ball y <= top y
		ballVy *= -1;
		// ballLoc.y = boxUpperRight.y - ballRadius;
	    }
	}
	if (paddleHit) {
	    paddleHitBallXSpeed += ballVx;
	    ballLoc.x = ballLoc.x + ballVx + paddleHitBallXSpeed;
	    ballLoc.y = ballLoc.y + ballVy;
	} else {
	    ballLoc.x = ballLoc.x + ballVx;
	    ballLoc.y = ballLoc.y + ballVy;
	}

	if (successCount[0] + successCount[1] > 20) {
	    running = false;
	}

    }

    ArrayList<String> getClientNames() {
	return clients;
    }

    public void addClientName(String name) {
	// TODO Auto-generated method stub
	this.clients.add(name);

    }

}
