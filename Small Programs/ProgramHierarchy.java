/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	public void run() {
		add(createNewRect(getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2, FIGURE_WIDTH, FIGURE_HEIGHT));//创立顶上的方框
		add(createNewRect(getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT, FIGURE_WIDTH, FIGURE_HEIGHT));//创立中间的方框
        add(createNewRect (getWidth()/2-FIGURE_WIDTH/2-k-FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT, FIGURE_WIDTH, FIGURE_HEIGHT));//创立左边方框
        add(createNewRect (getWidth()/2-FIGURE_WIDTH/2+k+FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT, FIGURE_WIDTH, FIGURE_HEIGHT));//创立右边方框   
        //至此，4个方框都在上面了
        add(createNewLine (getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+FIGURE_HEIGHT, getWidth()/2-FIGURE_WIDTH/2-k-FIGURE_WIDTH+FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));//创立左边线条
        add(createNewLine (getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+FIGURE_HEIGHT, getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));//创立中间的线条
        add(createNewLine (getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+FIGURE_HEIGHT, getWidth()/2+FIGURE_WIDTH+k, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));//创立右边线条    
        //至此，3条线都在上面了
        add(createNewLabel ("Program", getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2));
        add(createNewLabel ("GraphicsProgram", getWidth()/2-FIGURE_WIDTH/2-k-FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));
        add(createNewLabel ("ConsoleProgram", getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));
        add(createNewLabel ("DialogProgram", getWidth()/2-FIGURE_WIDTH/2+k+FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));
	}   //至此，所有东西都上去了	
	private GRect createNewRect (int x, int y, int FIGURE_WIDTH, int FIGURE_HEIGHT){   //方法-创建方框
		GRect rectangular = new GRect (x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
		return rectangular;
	}
	private GLabel createNewLabel (String B, int x, int y){                            //方法-创建字体
		GLabel label = new GLabel (B, x, y);
		label.setFont("Sanserif-16");
		double LABEL_WIDTH = label.getWidth();
		double LABEL_HEIGHT = label.getAscent();
		label.move((FIGURE_WIDTH-LABEL_WIDTH)/2, (FIGURE_HEIGHT-LABEL_HEIGHT)/2+LABEL_HEIGHT);
		return label;    //注意此类中.move的用法，                     
	}
	private GLine createNewLine (int x, int y, int x1, int y1){                        //方法-创建线条
		GLine line = new GLine (x, y, x1, y1);
		return line;
	}
	private static final int FIGURE_WIDTH = 160;  //方框长
	private static final int FIGURE_HEIGHT = 40;  //方框宽
	private static final int k = 20; //左边和中间方框 & 右边和中间方框 之间的距离
	private static final int l = 40; //topRect和middleRect之间线的距离
}
//写的略烦了，注意参数设置的合理性，.move方法在作图时候的熟练运用