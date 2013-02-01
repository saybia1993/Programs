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
		int val = readInt("Enter a number:　");
		   int counter = 0;
			while (val != 1){        //val不等于1
                counter++;           //计数器 ，每结束一个while循环，加1  
				if (val % 2 == 1){   //奇数时
					int x = val*3+1;
					println (val + " is odd, so I make 3n+1: " + x);
				    val = x;         //x的值重新赋给val，跳出if循环
				}
				else {
					int x = val/2;   //偶数时
					println(val + " is even, so i take half: " + x);
					val = x;         //x的值重新赋给val，跳出if循环
				}
			}
			println("The process took " + counter + " steps to reach 1");
	}
}
//while嵌套if+else，用于双向选择的循环中，注意在If/else循环中的x变量，本题重点
//计数循环步骤，while循环主体下面加一个counter即可

