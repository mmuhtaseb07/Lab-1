package assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{

	private LinkedList<CourseDBElement>[] table;
	private int size;
	
	public CourseDBStructure(int num) {
		size = (int) (num / 1.5);
		size = get4KPRIME(size);
		table = new LinkedList[size];
	}
	
	public CourseDBStructure(String numElements, int size) {
		this.size = size;
		table = new LinkedList[size];
	}

	public CourseDBElement get(int crn) throws IOException{
		for(int i = 0; i < size; i++) {
			if(table[i] != null) {
				for(int j = 0; j < table[i].size(); j++) {
					if(table[i].get(j).getCRN() == crn) {
						return table[i].get(j);
					}
				}
			}
		}
		throw new IOException("Course CRN not found!");
	}
	
	public static int get4KPRIME(int num) {
		boolean prime = false;
		while (!prime) {
			prime = true;

		    	for (int i = 2; i < num; i++) {
		    		if (num % i == 0) {
		                prime = false;
		                break;
		            }
		        }

	        if (prime && (num - 3) % 4 == 0) {
		           return num;
		        
	        }
		       num++;
		}
		
		return num;

	}
	
	public int getTableSize() {
		return size;
	}
	
	public ArrayList<String> showAll(){
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			if(table[i] != null) {
				for(int j = 0; j < table[i].size(); j++) {
					arr.add(table[i].get(j).toString());
					arr.add("\n");
				}
			}
		}
		return arr;
	}

	public void add(CourseDBElement element) {
		int hashCode = element.hashCode();
		int index = hashCode % size;
		
		if(table[index] == null) {
			table[index] = new LinkedList<>();
		}
		
		table[index].add(element);
		
	}
}
