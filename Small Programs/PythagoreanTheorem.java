/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
	println("Enter values to compute Pythagorean theorem");
	int a = readInt("a: ");
	int b = readInt("b: ");
	double c = Math.sqrt(a*a+b*b);
	println("c = "+c);
	}
}
//勾股定理，没啥好说的，注意平方可以用Math.pow(x, y)代替
