/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
/** Resets the display so that only the scaffold appears */
	public void reset() {
		GLine scaffold = new GLine(getWidth()/2-BEAM_LENGTH, BEAM_OFFSET_FROM_TOP, getWidth()/2-BEAM_LENGTH, SCAFFOLD_HEIGHT+BEAM_OFFSET_FROM_TOP);
		GLine beam = new GLine (getWidth()/2-BEAM_LENGTH, BEAM_OFFSET_FROM_TOP, getWidth()/2, BEAM_OFFSET_FROM_TOP);
		GLine rope = new GLine (getWidth()/2, BEAM_OFFSET_FROM_TOP, getWidth()/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH);
		add(scaffold);
		add(beam);
		add(rope);		
	}
/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		GLabel flag = new GLabel(word, getWidth()/2-BEAM_LENGTH, SCAFFOLD_HEIGHT+BEAM_OFFSET_FROM_TOP+20);
		add(flag);
	}
/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		GOval head = new GOval (getWidth()/2-HEAD_RADIUS, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH, HEAD_RADIUS*2, HEAD_RADIUS*2);
		GLine body = new GLine (getWidth()/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2, getWidth()/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
		GLine leftArm1 = new GLine (getWidth()/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD, getWidth()/2-UPPER_ARM_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		GLine leftArm2 = new GLine (getWidth()/2-UPPER_ARM_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD, getWidth()/2-UPPER_ARM_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		GLine rightArm1 = new GLine (getWidth()/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD, getWidth()/2+UPPER_ARM_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		GLine rightArm2 = new GLine (getWidth()/2+UPPER_ARM_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD, getWidth()/2+UPPER_ARM_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		GLine leftLeg1 = new GLine (getWidth()/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH, getWidth()/2-HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH); 
		GLine leftLeg2 = new GLine (getWidth()/2-HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH, getWidth()/2-HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
		GLine rightLeg1 = new GLine (getWidth()/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH, getWidth()/2+HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
		GLine rightLeg2 = new GLine (getWidth()/2+HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH, getWidth()/2+HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
		GLine leftFoot = new GLine (getWidth()/2-HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH, getWidth()/2-HIP_WIDTH/2-FOOT_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
		GLine rightFoot = new GLine (getWidth()/2+HIP_WIDTH/2, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH, getWidth()/2+HIP_WIDTH/2+FOOT_LENGTH, BEAM_OFFSET_FROM_TOP+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
		str += letter;
		GLabel lab = new GLabel (str, getWidth()/2-BEAM_LENGTH, SCAFFOLD_HEIGHT+BEAM_OFFSET_FROM_TOP+40);
		add(lab);
		int leng = str.length();
		switch (leng){
			case 1: add(head); break;
			case 2: add(body); break;
			case 3: add(leftArm1); add(leftArm2); break;
			case 4: add(rightArm1); add(rightArm2); break;
			case 5: add(leftLeg1); add(leftLeg2); break;
			case 6: add(rightLeg1); add(rightLeg2); break;
			case 7: add(leftFoot); break;
			case 8: add(rightFoot); break;
		}
	}
/** Constants for the simple version of the picture (in pixels) */
	private static final int BEAM_OFFSET_FROM_TOP = 40;
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private String str = "";   // store the input wrong letter
}
