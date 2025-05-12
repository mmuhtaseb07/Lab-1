package assignment6;

import java.util.ArrayList;

public class Town implements Comparable<Town>{

	private String name;
	private ArrayList<Town> adjTowns;
	
	public Town(String name) {
		this.name = name;
		adjTowns = new ArrayList<>();
	}
	
	// copy constructor
	public Town(Town templateTown) {
		name = templateTown.name;
		adjTowns = new ArrayList<>(templateTown.adjTowns);
	}
	
	// compares town objects based on names
	public int compareTo(Town o) {
		return name.compareTo(o.name);
	}
	
	// returns whether two town objects are equal based on name
	public boolean equals(Object obj) {
		if(getClass() == obj.getClass() && obj != null) {
			Town t = (Town) obj;
			return name.equals(t.getName());
		}
		return false;
	}
	
	// returns the town's name
	public String getName() {
		return name;
	}
	
	// returns the hashcode for the name of the town
	public int hashCode() {
		int sum = 0;
		
		for(int i = 0; i < name.length(); i++) {
			sum += name.charAt(i);
		}
		return sum % 9;
	}
	
	// returns town name
	public String toString() {
		return name;
	}
}
