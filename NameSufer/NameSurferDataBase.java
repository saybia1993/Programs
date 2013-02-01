/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */
import java.io.*;
import java.util.HashMap;

public class NameSurferDataBase implements NameSurferConstants {
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	
	public NameSurferDataBase(String filename) {  // a class with a particular input parameter
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader(filename));
			while (true){
				String line = rd.readLine();
				if (line == null) break;    
				/**���NameSurferEntry�������String���͵����ݣ�����Ҫȷ��NameSurferEntry(line)
				 * �е�line�����ݣ�����if (line == null) break; �������ǰ�棬���򵱶�ȡ�����һ��
				 * ��ʱ��line == null�ˣ�NameSurferEntry�ͻᱨ��
				 */
				NameSurferEntry obj = new NameSurferEntry(line);  
				data.put(obj.getName(), obj);  // corresponding name and NameSurferEntry 
			}
			rd.close();
		} 
		catch (IOException ex){
			System.out.println("no file!");
		}
	}
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		if (data.containsKey(name)) return data.get(name);
		return null;
	}

/** instance variable*/
	private HashMap<String, NameSurferEntry> data = new HashMap<String, NameSurferEntry>();
	
}



