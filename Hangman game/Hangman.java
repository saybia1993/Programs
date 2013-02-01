/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    private int index;          // the index of the word chosen by program for people to guess 
    private int indexOfStr;     // the index of string "-------"
    private int chance = 8;     // chances for try
    private char c;             // read the input word
    private String str = "";    // Initialization str for empty
    private HangmanCanvas canvas;  // object "canvas" belong to the class "HangmanCanvas"
    private RandomGenerator rgen = RandomGenerator.getInstance();
    
    /** add canvas besides console program*/
    public void init(){
    	canvas = new HangmanCanvas();
    	add(canvas);
	}  
    /** main method*/
    public void run() {
    	println("Welcome to Hangman!");
    	HangmanLexicon HangObject = new HangmanLexicon();
    	int r1 = HangObject.getWordCount(); // return how many words the list have
    	int r2 = rgen.nextInt(1, r1); // random number
    	String returnWords = HangObject.getWord(r2);     //returnWords store a random word
    	int Num = returnWords.length();  // Num store word's length
    	println("For testing, I give your the word: " +returnWords);  // Only for testing the program
    	/** initialize string str for "-------", output begin words*/
    	for (int i=0; i<Num; i++) str += "-";
    	println("The word now looks like this: "+str);
    	println("You have 8 guesses left");
    	canvas.reset();
    	while (chance>0){
    		String temp = readLine("Your Guess: ");
    		c = temp.charAt(0);   // read the input word and store it in char c
    		indexOfStr = str.indexOf(c);   // read index of c in str, store it in indexOfStr
    		if (indexOfStr !=-1) {     // indexOfStr != -1 means already exist same word in str
    	    	int temp2 = indexOfStr;   
    	    	while (temp2 !=-1){
    	    		indexOfStr = temp2;
    	    		temp2 = str.indexOf(c, indexOfStr+1);	//temp2 =-1,jump out of while loop
    	    	}                    
    	    	index = returnWords.indexOf(c, indexOfStr+1);
    	    	judgeForReplace();
    	    }
    	    else {                     // indexOfStr =-1 means no same word in str
    	    	index = returnWords.indexOf(c);
    	    	judgeForReplace();
    	    }
    	}
    	println("You have no chance for guess, YOU LOSE!");
	}
    /** method: judgeForReplace()*/
    private void judgeForReplace(){
		if (index !=-1){
			str = str.substring(0, index)+c+str.substring(index+1);   // replace the letter 
			canvas.displayWord(str);
			println("That guess is correct.");
			println("The word now looks like this: "+str);
			println("You have " + chance + " guesses left.");
		}
		else {
		println("There are no "+ c +" in the words");
		println("The word now looks like this: "+str);
		chance--;
		println("You have " + chance + " guesses left.");
		canvas.noteIncorrectGuess(c);
		}
	}
} // class ends
