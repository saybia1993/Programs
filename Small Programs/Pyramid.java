/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {
	public void run() {	 		
	    for (int i=14; i>0; i--){
	    	for (int j=i; j>0; j--){
	    		int x = (getWidth()-30*i)/2+30*(i-j); //ÿ�е�x������
	    		int y = getHeight()-(15-i)*12;  //ÿ�е�y������
	    		GRect rect = new GRect (x, y, 30, 12);
	    		add(rect);
	    	}
	    }
	}
	private static final int BRICK_WIDTH = 30;      //������
	private static final int BRICK_HEIGHT = 12;     //����߶�
	private static final int BRICKS_IN_BASE = 14;	//������������
}
//forѭ����Ƕ�ף������ں�����ͼ

