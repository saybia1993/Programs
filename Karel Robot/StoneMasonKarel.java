/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

/*
 * Name: songy6@uci.edu
 * Section Leader: ICS department
 */

public class StoneMasonKarel extends SuperKarel {

	//this is the basic idea for karel's action, decomposition shows later on
	public void run() {
		oneLineAction();
		while(frontIsClear()) {
		move();
		move();
		move();
		move();
		oneLineAction();
		}
	}
	
	//this is the basic idea for one line action for karel, decomposition shows later on
		private void oneLineAction() {		
		   turnLeft();
		   goAction();
		   turnAround();
		   returnAction();
		   turnLeft();
	}
		
	//this is the basic idea for goAction	
		private void goAction() {
		   while(frontIsClear()) {
		   if(noBeepersPresent()) {
		   putBeeper();
		   }
		   move();
		   }
		   if(noBeepersPresent()) {
			   putBeeper();
		   }
		}
		
	//this is the basic idea for returenAction
		private void returnAction() {
			while(frontIsClear()) {
				move();
			}
		}		   
}


