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
		add(createNewRect(getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2, FIGURE_WIDTH, FIGURE_HEIGHT));//�������ϵķ���
		add(createNewRect(getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT, FIGURE_WIDTH, FIGURE_HEIGHT));//�����м�ķ���
        add(createNewRect (getWidth()/2-FIGURE_WIDTH/2-k-FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT, FIGURE_WIDTH, FIGURE_HEIGHT));//������߷���
        add(createNewRect (getWidth()/2-FIGURE_WIDTH/2+k+FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT, FIGURE_WIDTH, FIGURE_HEIGHT));//�����ұ߷���   
        //���ˣ�4��������������
        add(createNewLine (getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+FIGURE_HEIGHT, getWidth()/2-FIGURE_WIDTH/2-k-FIGURE_WIDTH+FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));//�����������
        add(createNewLine (getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+FIGURE_HEIGHT, getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));//�����м������
        add(createNewLine (getWidth()/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+FIGURE_HEIGHT, getWidth()/2+FIGURE_WIDTH+k, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));//�����ұ�����    
        //���ˣ�3���߶���������
        add(createNewLabel ("Program", getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2));
        add(createNewLabel ("GraphicsProgram", getWidth()/2-FIGURE_WIDTH/2-k-FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));
        add(createNewLabel ("ConsoleProgram", getWidth()/2-FIGURE_WIDTH/2, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));
        add(createNewLabel ("DialogProgram", getWidth()/2-FIGURE_WIDTH/2+k+FIGURE_WIDTH, (getHeight()-(FIGURE_HEIGHT)*2-l)/2+l+FIGURE_HEIGHT));
	}   //���ˣ����ж�������ȥ��	
	private GRect createNewRect (int x, int y, int FIGURE_WIDTH, int FIGURE_HEIGHT){   //����-��������
		GRect rectangular = new GRect (x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
		return rectangular;
	}
	private GLabel createNewLabel (String B, int x, int y){                            //����-��������
		GLabel label = new GLabel (B, x, y);
		label.setFont("Sanserif-16");
		double LABEL_WIDTH = label.getWidth();
		double LABEL_HEIGHT = label.getAscent();
		label.move((FIGURE_WIDTH-LABEL_WIDTH)/2, (FIGURE_HEIGHT-LABEL_HEIGHT)/2+LABEL_HEIGHT);
		return label;    //ע�������.move���÷���                     
	}
	private GLine createNewLine (int x, int y, int x1, int y1){                        //����-��������
		GLine line = new GLine (x, y, x1, y1);
		return line;
	}
	private static final int FIGURE_WIDTH = 160;  //����
	private static final int FIGURE_HEIGHT = 40;  //�����
	private static final int k = 20; //��ߺ��м䷽�� & �ұߺ��м䷽�� ֮��ľ���
	private static final int l = 40; //topRect��middleRect֮���ߵľ���
}
//д���Է��ˣ�ע��������õĺ����ԣ�.move��������ͼʱ�����������