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
			else {             //����inputOne�д����˸ն����һ����Ϊ0������
				int inputTwo = readInt ("? ");   //����ĵڶ������ִ�����inputTwo��
				if (inputTwo == SENTINEL){
					println (inputOne + " as both the largest and smallest value");
				}
				else{          //����inputOne��inputTwo�������˲�Ϊ0��������
					while (true){         //ѭ�����忪ʼ
						inputOne = Math.max(inputOne, inputTwo); //inputOne�д���
						inputTwo = Math.min(inputOne, inputTwo); //inputTwo�д�С��
						int inputThree = readInt("? ");          //�������������
						if (inputThree == SENTINEL) break;
						boolean n = ((inputOne>inputThree)||(inputOne>inputTwo));
						if (n == false){
							int temp = inputOne; //��Сֵ
							inputOne = Math.max(inputTwo, inputThree); //���ֵ
							inputTwo = temp;
						}
						else {
							int temp = Math.min(inputThree, inputTwo);  //��Сֵ			        
					        int temp2 = Math.max(inputThree, inputTwo); 
					        inputOne = Math.max(temp2, inputOne);      //���ֵ
 					        inputTwo = temp;
						}                                               //����		
					}
					println ("smallest: " + inputTwo);
					println ("largest: " + inputOne);
				}
			}	
	}
	private static final int SENTINEL = 0;
}

