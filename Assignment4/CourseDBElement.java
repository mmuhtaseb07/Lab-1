package assignment4;

public class CourseDBElement implements Comparable<CourseDBElement>{
	
	private String id, roomNum, instructor;
	private int crn, credits;
	
	public CourseDBElement() {
		this.id = null;
		this.crn = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructor = null;
	}
	
	
	public CourseDBElement(CourseDBElement element) {
		this.id = element.id;
		this.crn = element.crn;
		this.credits = element.credits;
		this.roomNum = element.roomNum;
		this.instructor = element.instructor;
	}
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	public boolean equals(Object anotherObject) {
		if(anotherObject.getClass().equals(this.getClass())){
			return crn == ((CourseDBElement) anotherObject).crn;
		}
		return false;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public int getCRN() {
		return crn;
	}
	
	public String getID() {
		return id;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	
	public int hashCode() {
		String hash = "";
		hash += crn;
		int sum = 0;
		
		for(int i = 0; i < hash.length(); i++) {
			sum += hash.charAt(i);
		}
		
		return sum % 9;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	public String toString() {
		return "Course: " + id + " CRN: " + crn + " Credits: " + credits 
				+ " Instructor: " + instructor + " Room: " + roomNum;
	}

	@Override
	public int compareTo(CourseDBElement other) {
		return Integer.compare(this.crn, other.crn);
	}
}

