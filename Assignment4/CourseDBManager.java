package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{

	private CourseDBStructure s1;
	private final int DEFAULT_SIZE = 100;
	
	// creates a structure with default size
	public CourseDBManager() {
		s1 = new CourseDBStructure(DEFAULT_SIZE);
	}
	
	// adds a CourseDBElement object to the structure using given info
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement e1 = new CourseDBElement(id, crn, credits, roomNum, instructor);
		s1.add(e1);
	}
	
	// calls structure's get method to find CourseDBElement based on the crn key
	public CourseDBElement get(int crn) {
		return s1.get(crn);
	}
	
	// reads the information of courses from a test file and adds them to the CourseDBStructure data structure
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);
		while(scanner.hasNext()) {			
			String id = scanner.nextLine();
			int crn = scanner.nextInt();
			int credits = scanner.nextInt();
			scanner.nextLine();
			String roomNum = scanner.nextLine();
			String instructor = scanner.nextLine();
			
			add(id, crn, credits, roomNum, instructor);
		}
		scanner.close();
	}
	
	// calls structure's showAll method to return an ArrayList of string representation of each course in the structure
	public ArrayList<String> showAll(){
		return s1.showAll();
	}
}
