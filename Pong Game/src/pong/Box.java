package pong;

import java.awt.Point;
import java.io.Serializable;
import java.util.Random;

public class Box implements Serializable{

	//generic size
    static final int box_width = 1000; 
    static final int box_height = 500;

    Point boxUpperRight ;
    Point boxUpperLeft  ;
    Point boxLowerRight ;
    Point boxLowerLeft  ;
    
    Point rightHoleUpper     ;
    Point rightHoleLower     ;
    
    Point leftHoleUpper;
    Point leftHoleLower;
    
    Point ballLoc       ;
    
    Point[] paddleLoc     ;

    int paddleWidth ;
    int ballRadius = 20;    
    private int ballVx, ballVy;
    private Random rand = new Random();

    int[] successCount= new int[2];
    private boolean running=false;
    
    public boolean isRunning()
    {
        return running;
    }


    public Box()
    {
        int box_top =0;
        int box_bottom = box_height;
        int box_left =0;
        int box_right = box_width;

        boxUpperRight= new Point(box_right, box_top);
        boxUpperLeft = new Point(box_left, box_top);
        boxLowerRight= new Point(box_right, box_bottom);
        boxLowerLeft = new Point(box_left, box_bottom);
        rightHoleUpper    = new Point(box_right, box_top +(box_bottom-box_top)/4);
        rightHoleLower    = new Point(box_right, box_top +3*(box_bottom-box_top)/4);      

        leftHoleUpper    = new Point(box_left, box_top +(box_bottom-box_top)/4);
        leftHoleLower    = new Point(box_left, box_top +3*(box_bottom-box_top)/4);      
        paddleWidth  = (rightHoleLower.y - rightHoleUpper.y)/3;
        setGame(false);

    }
    void setGame(boolean startRunning)
    {
        int box_top =0;
        int box_bottom = box_height;
        int box_left =0;
        int box_right = box_width;
        
        // Start the ball out at a random spot
        ballLoc      = new Point(box_left+ rand.nextInt(box_right - box_left),
                box_top+ rand.nextInt(box_bottom - box_top));
        
        // Heuristic for generating random starting velocities ... maybe not the best
        ballVx = (-50 + (int)(100*Math.random()));
        ballVy = -50 + (int)(100*Math.random());
        
        paddleLoc = new Point[2];
        paddleLoc[0]     = new Point(box_right,( rightHoleUpper.y+rightHoleLower.y)/2);
        paddleLoc[1]    = new Point(box_left+1,( rightHoleUpper.y+rightHoleLower.y)/2);
        if (startRunning)
            running = true;
    }
    public void setPaddleY(int yLoc, int clientIndex)
    {
        paddleLoc[clientIndex].y =yLoc;
    }

    public void update()
    {
        if ( !running)
            return;
        ballLoc.x = ballLoc.x + ballVx;
        ballLoc.y = ballLoc.y + ballVy;

        // right paddle
        if (ballLoc.x + ballRadius >= boxUpperRight.x) // if ball x is >= right x
        {
            if (ballLoc.y >= paddleLoc[0].y-paddleWidth/2 && // if ball y is paddle yish
                    ballLoc.y <= paddleLoc[0].y + paddleWidth/2)
            {
        	successCount[0]++;
                ballVx *= -1;
                ballLoc.x = boxUpperRight.x - ballRadius;
                System.out.println("In Hole and hits paddle");
            } else { // created one giant hole
                running= false;
                System.out.println("In Hole and missed by paddle");
            }
        }
        
        if (ballLoc.x + ballRadius <= boxUpperLeft.x)
        {
            if (ballLoc.y >= paddleLoc[1].y-paddleWidth/2 &&
                    ballLoc.y <= paddleLoc[1].y + paddleWidth/2)
            {
                successCount[1]++;  // In hole but bounces off left paddle
                ballVx *= -1;
                ballLoc.x = boxUpperLeft.x + ballRadius;
                System.out.println("In Hole and hits paddle");
            }
            else
            {
                // In hole and missed by paddle
                running= false;
                System.out.println("In Hole and missed by paddle");
            }
        }

         // check against the top and bottom wall
        if (ballLoc.x - ballRadius < boxUpperRight.x || ballLoc.x - ballRadius > boxUpperLeft.x) // if ball x < right x || ball x > left x
        {
            if(ballLoc.y >= boxLowerRight.y) { // if ball y >= bottom y
        	ballVy *= -1;
                ballLoc.y = boxLowerRight.y + ballRadius;     
            } else if(ballLoc.y <= boxUpperRight.y) { // else if ball y <= top y
        	ballVy *= -1;
                ballLoc.y = boxUpperRight.y + ballRadius;      
            }
              
        }

    }

}