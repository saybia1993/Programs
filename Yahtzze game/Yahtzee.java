/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {       
		IODialog dialog = getDialog();    // initialize the dialog 
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers]; // 1*n array (1-dimension array)
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);  // read each name of the player
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}
	
	private void playGame() {
		/** 13 times circle */
		for (int k=0; k<13; k++){
			while (playerNum <= nPlayers) {  // One round circle
				display.printMessage("Its " + playerNames[playerNum-1]+ "'s turn now, roll the dices !");
				diceArray = new int [N_DICE]; // create an array which have 5 slot to sore the dice number
				for(int i=0; i<N_DICE; i++){
					diceArray [i] = rgen.nextInt(1,6); // store N_DICE for random value 1~6
				}
				display.waitForPlayerToClickRoll(playerNum);
				display.displayDice(diceArray);
				/*1st time re-roll*/
				display.printMessage("Hi "+playerNames[playerNum-1]+ ", select dices which you want to re-roll and roll the dices again !");
				display.waitForPlayerToSelectDice();  
				for (int i=0; i<5; i++){                    
					if (display.isDieSelected(i)) diceArray[i] = rgen.nextInt(1,6);
				}
				display.displayDice(diceArray);
				/*2nd time re-roll*/
				display.printMessage("Hi "+playerNames[playerNum-1]+ ", select dices which you want to re-roll and roll the dices for your last chance !");
				display.waitForPlayerToSelectDice();
				for (int j=0; j<5; j++){                    
					if (display.isDieSelected(j)) diceArray[j] = rgen.nextInt(1,6);
				}
				display.displayDice(diceArray); // roll end, at this time, diceArray holds the final stage of dices
				
				display.printMessage(playerNames[playerNum-1]+ ", make your choice now !");
				category = display.waitForPlayerToSelectCategory(); // return category number which selected by player
				boolean p = MyYahtzeeMagic(diceArray, category); // temporary method
				if (p == true){
					switchCase();
				}
				else  display.updateScorecard(category, playerNum, 0);
				playerNum++;
			}  // one round circle
			playerNum = 1; // reset playerNum =1
		}
		/** display upper score, lower score, total and if exist, store upper bonus */
		for (int r=1; r<=nPlayers; r++){
			display.updateScorecard(UPPER_SCORE, r, myArr[1][r]);
			display.updateScorecard(LOWER_SCORE, r, myArr[2][r]);
			if (myArr[1][r]>=63){
				display.updateScorecard(UPPER_BONUS, r, 35);
				myArr[0][r]=35;
			}
			else {
				display.updateScorecard(UPPER_BONUS, r, 0);
				myArr[0][r]=0;
			}
			display.updateScorecard(TOTAL, r, myArr[0][r]+myArr[1][r]+myArr[2][r]);
		}
	}
	/** whether p ==  true, put right value on the right position in screen*/
	private void switchCase(){
		switch (category){
		case 1: int temp1 =0;
			for (int i=0; i<5; i++) {
				if (diceArray[i]==1) temp1++;
			}
			display.updateScorecard(ONES, playerNum, temp1);  // display the result on the screen
			sumOfUpperCase(playerNum, temp1); // update information
			break;
		case 2: int temp2 =0;
			for (int i=0; i<5; i++) {
				if (diceArray[i]==2) temp2=temp2+2;
			}
			display.updateScorecard(TWOS, playerNum, temp2);
			sumOfUpperCase(playerNum, temp2);
			break;
		case 3: int temp3 =0;
			for (int i=0; i<5; i++) {
				if (diceArray[i]==3) temp3=temp3+3;
			}
			display.updateScorecard(THREES, playerNum, temp3); 
			sumOfUpperCase(playerNum, temp3);
			break;
		case 4: int temp4 =0;
			for (int i =0; i<5; i++){
				if (diceArray[i]==4) temp4=temp4+4;
			}
			display.updateScorecard(FOURS, playerNum, temp4);
			sumOfUpperCase(playerNum, temp4);
			break;
		case 5: int temp5 =0;
			for (int i =0; i<5; i++){
				if (diceArray[i]==5) temp5=temp5+5;
			}
			display.updateScorecard(FIVES, playerNum, temp5); 
			sumOfUpperCase(playerNum, temp5);
			break;
		case 6:	int temp6 =0;
			for (int i =0; i<5; i++){
				if (diceArray[i]==6) temp6=temp6+6;
			}
			display.updateScorecard(SIXES, playerNum, temp6); 
			sumOfUpperCase(playerNum, temp6);
			break;
			
		case 9: int temp9 =0;
			for (int i=0; i<5; i++){
				temp9=temp9+diceArray[i];
			}
			display.updateScorecard(THREE_OF_A_KIND, playerNum, temp9);
			sumOfLowerCase(playerNum, temp9);
			break;
		case 10: int temp10 =0;
		 	 for (int i=0; i<5; i++){
				 temp10=temp10+diceArray[i];
			 }
			 display.updateScorecard(FOUR_OF_A_KIND, playerNum, temp10);
			 sumOfLowerCase(playerNum, temp10);
			 break;
		case 11: display.updateScorecard(FULL_HOUSE, playerNum, 25);
			 sumOfLowerCase(playerNum, 25);
			 break;
		case 12: display.updateScorecard(SMALL_STRAIGHT, playerNum, 30);
			 sumOfLowerCase(playerNum, 30);
			 break;
		case 13: display.updateScorecard(LARGE_STRAIGHT, playerNum, 40);
			 sumOfLowerCase(playerNum, 40);
			 break;
		case 14: display.updateScorecard(YAHTZEE, playerNum, 50);
			 sumOfLowerCase(playerNum, 50);
			 break;
		case 15: int temp15 = 0;
			 for (int i=0; i<5; i++){
				 temp15=temp15+diceArray[i];
			 }
			 display.updateScorecard(CHANCE, playerNum, temp15);
			 sumOfLowerCase(playerNum, temp15);
			 break;
		}
	}
	/** store players' upper score*/
	private void sumOfUpperCase(int playerNum, int value){
		switch (playerNum){
		case 1: myArr [1][1] = myArr [1][1]+value; break;
		case 2: myArr [1][2] = myArr [1][2]+value; break;
		case 3: myArr [1][3] = myArr [1][3]+value; break;
		case 4: myArr [1][4] = myArr [1][4]+value; break;
		}
	}
	/** store players' lower score*/
	private void sumOfLowerCase(int playerNum, int value){
		switch (playerNum){
		case 1: myArr [2][1] = myArr [2][1]+value; break;
		case 2: myArr [2][2] = myArr [2][2]+value; break;
		case 3: myArr [2][3] = myArr [2][3]+value; break;
		case 4: myArr [2][4] = myArr [2][4]+value; break;
		}
	}
	/** my method to determining whether a dice configuration meets the requirements*/
	private boolean MyYahtzeeMagic (int[] dice, int category){
		int [] difference = new int[10];  // store 6 dices' 10 differences
		difference[0]= diceArray[0]-diceArray[1];
		difference[1]= diceArray[0]-diceArray[2];
		difference[2]= diceArray[0]-diceArray[3];
		difference[3]= diceArray[0]-diceArray[4];
		difference[4]= diceArray[1]-diceArray[2];
		difference[5]= diceArray[1]-diceArray[3];
		difference[6]= diceArray[1]-diceArray[4];
		difference[7]= diceArray[2]-diceArray[3];
		difference[8]= diceArray[2]-diceArray[4];
		difference[9]= diceArray[3]-diceArray[4];
		int counter =0;
		for (int i=0; i<10; i++){
			if (difference[i]==0) counter++;
		}
        /** "three of a kind", "four of a kind", "full house", "yahtzee"*/
		if ((counter == 10)&&((category == YAHTZEE)||(category == THREE_OF_A_KIND)||(category == FOUR_OF_A_KIND))) return true;
		else if ((counter == 6)&&(category == THREE_OF_A_KIND)) return true;
		else if ((counter == 6)&&(category == FOUR_OF_A_KIND)) return true;
		else if ((counter == 4)&&(category == FULL_HOUSE)) return true;
		else if ((counter == 4)&&(category == THREE_OF_A_KIND)) return true;
		else if ((counter == 3)&&(category == THREE_OF_A_KIND)) return true;
        /** "large straight", "small straight"*/
		else if (((diceHave(1)&&diceHave(2)&&diceHave(3)&&diceHave(4)&&diceHave(5))||(diceHave(2)&&diceHave(3)&&diceHave(4)&&diceHave(5)&&diceHave(6)))&&(category == LARGE_STRAIGHT)) return true;
		else if (((diceHave(1)&&diceHave(2)&&diceHave(3)&&diceHave(4))||(diceHave(2)&&diceHave(3)&&diceHave(4)&&diceHave(5))||(diceHave(3)&&diceHave(4)&&diceHave(5)&&diceHave(6)))&&(category == SMALL_STRAIGHT)) return true; 
		/** "ones, twos, threes, fours, fives, sixes", "chance"*/
		else if (category == ONES) return true;
		else if (category == TWOS) return true;
		else if (category == THREES) return true;
		else if (category == FOURS) return true;
		else if (category == FIVES) return true;
		else if (category == SIXES) return true;
		else if (category == CHANCE) return true;
		return false;
	}
	/** testing whether diceArray have the particular dice value*/
	private boolean diceHave(int compareValue){
		for (int i=0; i<5; i++){
			if (diceArray[i]== compareValue) return true;
		}
		return false;
	}
    /** Private instance variables */
	private int nPlayers;      // variable "nPlayers" refer to number of players 
	private String[] playerNames;   // input players' name and store them in String
	private YahtzeeDisplay display;  // YahtzeeDisplay class's object "display"
	private RandomGenerator rgen = new RandomGenerator(); // ---
	private int[] diceArray;  // diceArray store the dice's value
	private int category;
	private int playerNum =1;  // point to the first player
	private int [][] myArr = new int [3][5]; // create an array to store the upper and lower score
}
