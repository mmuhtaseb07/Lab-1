package assignment6;

public class Road implements Comparable<Road>{

	private Town source, destination; 
	private int degrees;
	private String name;
	
	public Road(Town source, Town destination, int degrees, String name){
		this.source = source;
		this.destination = destination;
		this.name = name;
		this.degrees = degrees;
	}
	
	public Road(Town source, Town destination, String name){
		this(source, destination, 1, name);
	}
	
	// compares two road objects based on name
	public int compareTo(Road o) {
		return name.compareTo(o.name);
	}
	
	// returns true only if the edge contains the given town
	public boolean contains(Town town) {
		return source.equals(town) || destination.equals(town);
	}
	
	// returns true if each of the ends of the road r is the same as the ends of this road
	public boolean equals(Object r) {
		if(getClass() == r.getClass() && r != null){
			Road road = (Road) r;
			
			if(!name.equals(road.name) || degrees != road.degrees) {
				return false;
			}
			if(source.equals(road.source) && destination.equals(road.destination)) {
				return true;
			}
			if(source.equals(road.destination) && destination.equals(road.source)){
				return true;
			}
		}
		return false;
	}
	
	// returns the second town on the road
	public Town getDestination() {
		return destination;
	}
	
	// returns the road name
	public String getName() {
		return name;
	}
	
	// returns the first town on the road
	public Town getSource() {
		return source;
	}
	
	// returns the distance of the road
	public int getWeight() {
		return degrees;
	}
	
	// returns string representation of road
	public String toString() {
		return name;
	}
}
