/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;
import acm.graphics.*;
import java.lang.Math;

public class FindRange extends ConsoleProgram {
	public void run() {
		println ("This program finds the largest and smallest numbers.");
			int inputOne = readInt("? ");
			if (inputOne == SENTINEL){
				println("no values have been entered");
			}
			else {             //现在inputOne中储存了刚读入的一个不为0的数字
				int inputTwo = readInt ("? ");   //读入的第二个数字储存在inputTwo中
				if (inputTwo == SENTINEL){
					println (inputOne + " as both the largest and smallest value");
				}
				else{          //现在inputOne与inputTwo都储存了不为0的两个数
					while (true){         //循环主体开始
						inputOne = Math.max(inputOne, inputTwo); //inputOne中存大的
						inputTwo = Math.min(inputOne, inputTwo); //inputTwo中存小的
						int inputThree = readInt("? ");          //读入第三个数字
						if (inputThree == SENTINEL) break;
						boolean n = ((inputOne>inputThree)||(inputOne>inputTwo));
						if (n == false){
							int temp = inputOne; //最小值
							inputOne = Math.max(inputTwo, inputThree); //最大值
							inputTwo = temp;
						}
						else {
							int temp = Math.min(inputThree, inputTwo);  //最小值			        
					        int temp2 = Math.max(inputThree, inputTwo); 
					        inputOne = Math.max(temp2, inputOne);      //最大值
 					        inputTwo = temp;
						}                                               //结束		
					}
					println ("smallest: " + inputTwo);
					println ("largest: " + inputOne);
				}
			}	
	}
	private static final int SENTINEL = 0;
}

