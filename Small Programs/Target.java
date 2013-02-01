/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		int x = getWidth()/2;
		int y = getHeight()/2;
		add(createdFilledCirlce(x, y, 72, Color.RED));
		add(createdFilledCirlce(x, y, 47, Color.WHITE));
		add(createdFilledCirlce(x, y, 22, Color.RED));

	}	
	private GOval createdFilledCirlce (int x, int y, int r, Color color){
		GOval circle = new GOval (x-r, y-r, 2*r, 2*r);
		circle.setColor(color);
		circle.setFilled(true);
		return circle;
	}
}
//具有相似类型，可以用相同参数表示的物体，需要熟练运用method，这样能简化编程步骤
