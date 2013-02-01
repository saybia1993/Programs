/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int val = readInt("Enter a number:��");
		   int counter = 0;
			while (val != 1){        //val������1
                counter++;           //������ ��ÿ����һ��whileѭ������1  
				if (val % 2 == 1){   //����ʱ
					int x = val*3+1;
					println (val + " is odd, so I make 3n+1: " + x);
				    val = x;         //x��ֵ���¸���val������ifѭ��
				}
				else {
					int x = val/2;   //ż��ʱ
					println(val + " is even, so i take half: " + x);
					val = x;         //x��ֵ���¸���val������ifѭ��
				}
			}
			println("The process took " + counter + " steps to reach 1");
	}
}
//whileǶ��if+else������˫��ѡ���ѭ���У�ע����If/elseѭ���е�x�����������ص�
//����ѭ�����裬whileѭ�����������һ��counter����

