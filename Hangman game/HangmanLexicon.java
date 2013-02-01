/*
* File: HangmanLexicon.java
* -------------------------
* This file contains a stub implementation of the HangmanLexicon
* class that you will reimplement for Part III of the assignment.
*/

import acm.util.*;
import java.util.*;
import java.io.*;

public class HangmanLexicon {
        private ArrayList<String> ShorterLexicon = new ArrayList<String>();  //ArrayList, String type
        HangmanLexicon(){
        	BufferedReader rd = null;
            try{
            	rd = new BufferedReader(new FileReader("ShorterLexicon.txt"));
                String line = rd.readLine();   // read the first line of word
                while(line != null){          
                ShorterLexicon.add(line);      // add word line by line in ArrayList    
                line = rd.readLine();          // read the next line of word
                }
                rd.close();
            } 
            catch (IOException ex){System.out.println("CANNOT FIND THE FILE");}
        }
        public int getWordCount() {
        	return ShorterLexicon.size();   // return the number of elements in this list
        }
        public String getWord(int index) {
            return ShorterLexicon.get(index);  // Returns the element at the specified position in this list
        }
}