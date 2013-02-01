/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
	    name = new JLabel("Name");  
	    add(name, SOUTH);
	    textField = new JTextField(20);
	    add(textField, SOUTH);
	    graph = new JButton("Graph");
	    add(graph, SOUTH);
	    clear = new JButton("Clear");
	    add(clear, SOUTH);
	    
	    textField.addActionListener(this);
	    addActionListeners();
	    
	    picture = new NameSurferGraph();
	    add(picture);
	}
	
/* Method: actionPerformed(e) */                                                                
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {   // actions
		
		TRYONE = new NameSurferDataBase(NAMES_DATA_FILE);
		obj = TRYONE.findEntry(textField.getText());  // return an Object of NameSurferEntry
		
		String cmd = e.getActionCommand();
		if (obj != null){
			if (cmd.equals("Graph"))            picture.addEntry(obj);            
			if (e.getSource() == textField)     picture.addEntry(obj);    
			if (cmd.equals("Clear"))            picture.clear();
		} else {
			System.out.println("No name!");    // 控制台弹出，有时间可以做成dialogue模式
		}
	}

/** instance variable*/
	private JLabel name;
	private JTextField textField;
	private JButton graph;
	private JButton clear;
	private NameSurferGraph picture;
	private NameSurferDataBase TRYONE;
	private NameSurferEntry obj;


}