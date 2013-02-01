/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

/*
 * Name: songy6@uci.edu
 * Section Leader: ICS department
 */

/*basic idea for karel to fill the world, decomposition shows later on*/
public class CheckerboardKarel extends SuperKarel { 
	public void run() {
		oneLineAction();   //karel's first line action. pre-condition, post-condition both facing east
		while(frontIsClear()){         
         if(beepersPresent()){
    	  move();                    //2,4,6,8,10.... line action
    	  turnLeft();
    	  move();
    	  turnRight();
    	  oneLineAction();
      }
    	  else {                        
    		move();                  //3,5,7,9,11.... line action
    		oneLineAction();  
    	  }
      }
	}

	/*oneLineAction decomposition*/
	private void oneLineAction() {
		turnLeft();
		goAction();                   //karel's one line go action
		turnAround();
		returnAction();               //karel's one line return action
		turnLeft();
	}
	
	/*goAction decomposition, key idea for this question*/
	private void goAction() {
		while(frontIsClear()) {       //while row high is odd number，"while" ends the circulation, it also cause off by one bug
		    putBeeper();              //while circulation ends, try to go back one row and test to decide if put one beeper or not
		    move();                
		    if(frontIsClear()) {      //while row high is even，"if" ends the circulation
		    	move();
		    }
		}
		
		turnAround();                 //go back one row and test
		if(frontIsClear()){
		move();
		if(noBeepersPresent()) {
			turnAround();
			move();
			putBeeper();
		}
		else {                        //此else对应if(noBeepersPresent())这个循环
			    turnAround();
				move();
			 }
			
		}
		else {
			oneLineAction();          //此else对应if(frontIsClear())这个循环
	    }                             //加此句的目的是为了防止当只有一行的时候，退一格检测奇偶的方法会报错
}                                     //注意oneLineAction定义的初始方向与实际的goAction呈90度
 
	/*returnAction decomposition*/
	private void returnAction() {
		while(frontIsClear()){
		move();
	}
	}
}
