package assignment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface{

	private Graph graph = new Graph();
	private Map<String, Town> towns = new HashMap<>();
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1 = towns.get(town1);
		Town t2 = towns.get(town2);
		
		if(t1 == null || t2 == null) {
			return false;
		}
		graph.addEdge(t1, t2, weight, roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town t1 = towns.get(town1);
		Town t2 = towns.get(town2);
		
		if(t1 == null || t2 == null) {
			return null;
		}
		
		Road r = graph.getEdge(t1, t2);
		if(r != null) {
			return r.getName();

		}
		
		return null;
	}

	@Override
	public boolean addTown(String v) {
		if(towns.containsKey(v)) {
			return false;
		}
		
		Town t = new Town(v);
		towns.put(v, t);
		graph.addVertex(t);
		return true;
	}

	@Override
	public Town getTown(String name) {
		return towns.get(name);
	}

	@Override
	public boolean containsTown(String v) {
		return towns.containsKey(v);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return getRoad(town1, town2) != null;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> list = new ArrayList<>();
		for(Road r : graph.edgeSet()) {
			list.add(r.getName());
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = towns.get(town1);
		Town t2 = towns.get(town2);
		
		if(t1 == null || t2 == null) {
			return false;
		}
		
		Road r = graph.getEdge(t1, t2);
		if(r == null || !r.getName().equals(road)) {
			return false;
		}
		
		graph.removeEdge(t1, t2, r.getWeight(), road);
		return true;
	}

	@Override
	public boolean deleteTown(String v) {
		Town t = towns.remove(v);
		if(t == null) {
			return false;
		}
		graph.removeVertex(t);
		return true;
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> list = new ArrayList<>(towns.keySet());
		Collections.sort(list);
		return list;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1 = towns.get(town1);
		Town t2 = towns.get(town2);
		
		if(t1 == null || t2 == null) {
			return null;
		}
		ArrayList<String> path = graph.shortestPath(t1, t2);
		if(path == null) {
			return null;
		}
		return path;
	}

	public void populateTownGraph(File file) throws FileNotFoundException, IOException {
	    if (!file.exists()) {
	        throw new FileNotFoundException();
	    }
	    if (!file.canRead()) {
	        throw new IOException();
	    }

	    Scanner in = new Scanner(file);
	    while (in.hasNextLine()) {
	        String line = in.nextLine().trim();
	        String[] parts = line.split(";");

	        String a = parts[0].trim();
	        String b = parts[1].trim();
	        int w = Integer.parseInt(parts[2].trim());
	        String name = parts[3].trim();

	        addTown(a);
	        addTown(b);
	        addRoad(a, b, w, name);
	    }
	    in.close();
	}

}
