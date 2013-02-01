/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

/*
 * Name: songy6@uci.edu
 * Section Leader:  ICS department
 */

public class CollectNewspaperKarel extends SuperKarel {
	
	/*
	 * this is my first decomposition program of karel the robot
	 * public class include karel's basic movement methods
	 */
	
	public void run() {
		moveToNewspaper();
		pickBeeper();
		turnAround();
		returnToStartpoint();
	   }
	
	//this is move to newspaper's decomposition
		private void moveToNewspaper() {
			move();
			move();
			turnRight();
			move();
			turnLeft();
			move();
	   }
		
	//this is return to startpoint's decomposition	
		private void returnToStartpoint() {
			move();
			turnRight();
			move();
			turnLeft();
			move();
			move();
			turnAround();
	   }
}
