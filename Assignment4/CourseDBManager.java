package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{

	private CourseDBStructure s1;
	
	public CourseDBManager() {
		s1 = new CourseDBStructure(100);
	}
	
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement e1 = new CourseDBElement(id, crn, credits, roomNum, instructor);
		s1.add(e1);
	}
	
	public CourseDBElement get(int crn) {
		return s1.get(crn);
	}
	
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
	
	public ArrayList<String> showAll(){
		return s1.showAll();
	}
}
