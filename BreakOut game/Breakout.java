/*
* File: Breakout.java
* -------------------
* Name:
* Section Leader:
* 
* This file will eventually implement the game of Breakout.
*/

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */ 
        public static final int APPLICATION_WIDTH = 400;
        public static final int APPLICATION_HEIGHT = 700;

/** Dimensions of game board (usually the same) */
        private static final int WIDTH = APPLICATION_WIDTH;
        private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
        private static final int PADDLE_WIDTH = 200;
        private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
        private static final int PADDLE_Y_OFFSET = 80;

/** Number of bricks per row */
        private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
        private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
        private static final int BRICK_SEP = 4;

/** Width of a brick */
        private static final int BRICK_WIDTH =(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
        private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
        private static final int BALL_RADIUS = 7;

/** Offset of the top brick row from the top */
        private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
        private static final int NTURNS = 3;

/** Next are my static constant*/
        private static final int DELAY = 10; // animation delay or pause time between ball moves
        private static final int x_START_VELOCITY = 8; // starting x-coordinate velocity
        private static final int y_START_VELOCITY = 10; // starting y-coordinate velocity

/** Next are my own instance variables */
        private GPoint last;  // variable "last" (x.getX(),y.getY()) stores the position of mouse
        private GRect paddle; // create paddle
        private GOval ball;   // create bouncing ball
        private GRect brick;  // create bricks
        private GLabel Label; // create label to show "win" or "lose"
        private int yVELOCITY = y_START_VELOCITY; // y-coordinate velocity (variable)
        private int xVELOCITY = x_START_VELOCITY; // x-coordinate velocity (setting to constant)
        private int amount = 100; // amount of bricks

/** Breakout program begins */
        public void init(){    // event driven program
                addMouseListeners();
        }
        public void mouseEntered(MouseEvent e){  // listen to the mouse when enter the canvas
                last = new GPoint(e.getPoint());     // last store the mouse position
        }
        public void mouseMoved(MouseEvent e){
                if ((e.getX()>=PADDLE_WIDTH/2)&&(e.getX()<=APPLICATION_WIDTH-PADDLE_WIDTH/2)){
                paddle.setLocation(e.getX()-PADDLE_WIDTH/2, APPLICATION_HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
                paddle.move(e.getX()-last.getX(), 0);  
                last = new GPoint(e.getPoint());  // store last coordinate in variable "last"
                }
                else {
                paddle.move(0, 0);
                }
        }
        
        public void run() {  // main method
                createBricks();
                createPaddle(); 
                createBall();
                gameCircle();
                }

        private void createBricks(){  // method
                for (int i=0; i<NBRICKS_PER_ROW; i++){  // each row (for loop create 100 bricks)
                        for (int j=0; j<NBRICK_ROWS; j++){  // each column
                                int x =(BRICK_WIDTH+BRICK_SEP)*i; // bricks' X-coordinates
                                int y = BRICK_Y_OFFSET+(BRICK_HEIGHT+BRICK_SEP)*j; // bricks' Y-coordinates
                                brick = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
                                if ((j>=0)&&(j<=1)){
                                brick.setColor(Color.RED);
                                brick.setFilled(true);
                                add(brick);
                                }
                                else if((j>=2)&&(j<=3)){
                                brick.setColor(Color.ORANGE);
                                brick.setFilled(true);
                                add(brick);
                                }
                                else if((j>=4)&&(j<=5)){
                                brick.setColor(Color.YELLOW);
                                brick.setFilled(true);
                                add(brick);
                                }
                                else if((j>=6)&&(j<=7)){
                                brick.setColor(Color.GREEN);
                                brick.setFilled(true);
                                add(brick);
                                }
                                else if((j>=8)&&(j<=9)){
                                brick.setColor(Color.CYAN);
                                brick.setFilled(true);
                                add(brick);
                                }
                        }
                }
        }
        
        private void createPaddle(){ // method
                paddle = new GRect ((APPLICATION_WIDTH-PADDLE_WIDTH)/2, APPLICATION_HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT); //paddle's start position
                paddle.setFilled(true);
                paddle.setColor(Color.BLACK);
                add(paddle);
        }
        
        private void createBall(){  // method
                ball = new GOval (2, APPLICATION_HEIGHT/2, BALL_RADIUS*2, BALL_RADIUS*2);
                ball.setFilled(true);
                add(ball);
        }
        
        private void gameCircle(){ // method
                while (amount>0){
                        moveBall();
                        checkForSideCollision(); // this method contains "lose" condition
                        checkForBrickCollision();
                        pause(DELAY);
                }
                Label= new GLabel("You Win!", 180, 250); // "win" condition
                Label.setColor(Color.RED);
                add(Label);
        }  

        private void moveBall(){   // method
                ball.move(xVELOCITY, yVELOCITY);
        }
        
        private void checkForSideCollision(){ // method
                if (ball.getY()+BALL_RADIUS*2>=getHeight()){ //bottom
                        Label = new GLabel ("You Lose!", 180, 250);
                        Label.setColor(Color.RED);
                        add(Label);
                }
                else if (ball.getX()+BALL_RADIUS*2>=getWidth()){ //right side
                        xVELOCITY = -xVELOCITY;                 
                }
                else if (0>=ball.getY()){ //top
                        yVELOCITY = -yVELOCITY;
                }
                else if (0>=ball.getX()){ //left side
                        xVELOCITY = -xVELOCITY;
                }
        }
        
        private void checkForBrickCollision(){  // method
                GObject collObj1 = getElementAt(ball.getX()+BALL_RADIUS, ball.getY()-1); // upper point
                GObject collObj2 = getElementAt(ball.getX()+BALL_RADIUS*2+1, ball.getY()+BALL_RADIUS); //right point
                GObject collObj3 = getElementAt(ball.getX()+BALL_RADIUS, ball.getY()+BALL_RADIUS*2+1); //bottom point
                GObject collObj4 = getElementAt(ball.getX()-1, ball.getY()+BALL_RADIUS); //left point
                if (collObj3 == paddle){
                        yVELOCITY = -yVELOCITY;
                }
                else if ((collObj1!=null)&&(collObj1!= paddle)){
                        remove(collObj1);
                        amount--;
                        yVELOCITY = -yVELOCITY;
                }        
                else if ((collObj2!=null)&&(collObj2!= paddle)){
                        remove(collObj2);
                        amount--;
                        xVELOCITY = -xVELOCITY;
                }
                else if ((collObj3!=null)&&(collObj3!= paddle)){
                        remove(collObj3);
                        amount--;
                        yVELOCITY = -yVELOCITY;
                }
                else if ((collObj4!=null)&&(collObj4!= paddle)){
                        remove(collObj4);
                        amount--;
                        xVELOCITY = -xVELOCITY;
                }
        }
} // main class ends