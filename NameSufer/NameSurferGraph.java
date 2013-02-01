/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		list.clear();
		update();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		list.add(entry);
		update();
	}
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		/** re-sizable*/
		removeAll();
		GLine marginUp = new GLine (0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE);
		GLine marginDown = new GLine (0, getHeight()-GRAPH_MARGIN_SIZE, getWidth(), getHeight()-GRAPH_MARGIN_SIZE);
		add(marginUp);
		add(marginDown);
		for (int i=0; i<11; i++){
			GLine verticals = new GLine ((getWidth()/11)*i, 0,  (getWidth()/11)*i, getHeight());
			add(verticals);
		}
		for (int i=0; i<11; i++){
			int temp = 1900+10*i;
			String s= String.valueOf(temp);
			GLabel years = new GLabel(s, (getWidth()/11)*i, getHeight());
			add(years);
		}
		/** graphic operation*/
		int k = getHeight()-GRAPH_MARGIN_SIZE*2;  // height for calculate
		int n = list.size();   // if there exist 4 elements, the index of them is:0,1,2,3
		while ((n-1) >=0){
			NameSurferEntry obj = list.get(n-1);         // list.get(n-1) is the object of NameSurferEntry
				for (int i=0; i<10; i++){                // draw line 
					rankOfName = obj.getRank(i);       
					rankOfNextName = obj.getRank(i+1);     
					if (rankOfName == 0) rankOfName = 1001;           // lower the 0 coordinate
					if (rankOfNextName == 0) rankOfNextName = 1001;   // lower the 0 coordinate
					GLine x = new GLine(getWidth()*i/11, rankOfName*k/MAX_RANK+20, getWidth()*(i+1)/11, rankOfNextName*k/MAX_RANK+20);
					x.setColor(myColor(n-1));
					add(x);   //  take care of the accuracy in JAVA!! Some times division get an ¡°0¡± !!
					intToString = String.valueOf(rankOfName);  
					if (rankOfName == 1001) intToString = "*";
					GLabel y = new GLabel(obj.getName()+" "+intToString, getWidth()*i/11, rankOfName*k/MAX_RANK+20);
					y.setColor(myColor(n-1));
					add(y);
				}
				/** the last label of name*/
				String intToStringNext = String.valueOf(rankOfNextName);
				if (rankOfNextName == 1001) intToStringNext = "*";
				GLabel z = new GLabel(obj.getName()+" "+ intToStringNext, getWidth()/11*10, rankOfNextName*k/MAX_RANK+20);
				z.setColor(myColor(n-1));
				add(z);
				n--;
		}
	}
	
	private Color myColor(int num){
		switch (num%4){
		case 0: return Color.black;
		case 1: return Color.red;
		case 2: return Color.blue;
		case 3: return Color.magenta;
		default: return Color.black;
		}
	}
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
/**instance variable*/
	private ArrayList <NameSurferEntry> list = new ArrayList <NameSurferEntry>();
	private int rankOfName;      // rank of the name, the value of "i" in obj.getRank(i) is 9 when circle ends
	private int rankOfNextName;  // rank of the next name, the value of "i" in obj.getRank(i) is 10 when circle ends
	private String intToString;  // convert rankOfName from integer to string type
}
