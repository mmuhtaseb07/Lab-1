package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{
	
	private Map<Town, ArrayList<Road>> adjList;
    private Map<Town,Integer> distances;     
    private Map<Town,Town> prev;             
	
	public Graph() {
		adjList = new HashMap<Town, ArrayList<Road>>();
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}

		ArrayList<Road> sourceEdges = adjList.get(sourceVertex);
		if(sourceEdges == null) {
			return null;
		}
		
		for(int i = 0; i < sourceEdges.size(); i++) {
			Road road = sourceEdges.get(i);
			if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)){
				return road;
			}
			if(road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex)){
				return road;
			}
		}
		
		return null;
		
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description){
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		if(!adjList.containsKey(sourceVertex) || !adjList.containsKey(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		
		adjList.get(sourceVertex).add(newRoad);
		adjList.get(destinationVertex).add(newRoad);
		
		return newRoad;
	}

	@Override
	public boolean addVertex(Town v) {
		if(v == null) {
			throw new NullPointerException();
		}
		if(!adjList.containsKey(v)) {
			adjList.put(v, new ArrayList<Road>());
			return true;
		}
		return false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null) {
			return false;
		}

		ArrayList<Road> sourceEdges = adjList.get(sourceVertex);
		if(sourceEdges == null) {
			return false;
		}
		
		
		for(int i = 0; i < sourceEdges.size(); i++) {
			Road road = sourceEdges.get(i);
			if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)){
				return true;
			}
			if(road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex)){
				return true;
			}
		}
		
		return false;
	}

	
	@Override
	public boolean containsVertex(Town v) {
		if(v == null) {
			return false;
		}
		return adjList.containsKey(v);
	}

	@Override
	public Set<Road> edgeSet() {
	    Set<Road> edgeSet = new HashSet<Road>();
	    ArrayList<Town> townList = new ArrayList<Town>(adjList.keySet());

	    for (int i = 0; i < townList.size(); i++) {
	        Town town = townList.get(i);
	        ArrayList<Road> roads = adjList.get(town);

	        for (int j = 0; j < roads.size(); j++) {
	            Road road = roads.get(j);
	            edgeSet.add(road);
	        }
	    }

	    return edgeSet;
	}
	

	@Override
	public Set<Road> edgesOf(Town vertex) {
		if(vertex == null) {
			throw new NullPointerException("Vertex is null");
		}
		if(!adjList.containsKey(vertex)) {
			throw new IllegalArgumentException();
		}
		
		Set<Road> edgeSet = new HashSet<Road>();
		ArrayList<Road> roads = adjList.get(vertex);
		
		for(int i = 0; i < roads.size(); i++) {
			edgeSet.add(roads.get(i));
		}
		
		return edgeSet;
	}

	// 
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
		if(!adjList.containsKey(sourceVertex) || !adjList.containsKey(destinationVertex)) {
			return null;
		}
		
		ArrayList<Road> sourceEdges = adjList.get(sourceVertex);
		
		for(int i = 0; i < sourceEdges.size(); i++) {
			Road road = sourceEdges.get(i);
			if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex) ||
			   road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex)){
				   
				  if((weight == -1 || road.getWeight() == weight) && (description == null || road.getName().equals(description))){
					  adjList.get(sourceVertex).remove(i);
					  
					  for(int j = 0; j < adjList.get(destinationVertex).size(); j++) {
						  if(adjList.get(destinationVertex).get(j).equals(road)) {
							  adjList.get(destinationVertex).remove(j);
							  break;
						  }
					  }
					  
					  return road;
				  }
				  
			}
			
		}
		
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		if(v == null || !adjList.containsKey(v)) {
			return false;
		}
		
		ArrayList<Road> edges = adjList.get(v);
		for(int i = 0; i < edges.size(); i++) {
			Road r = edges.get(i);

			if(!r.getSource().equals(v)) {
				ArrayList<Road> otherEdges = adjList.get(r.getSource());
				for(int j = 0; j < otherEdges.size(); j++) {
					if(otherEdges.get(j).equals(r)) {
						otherEdges.remove(j);
						break;
					}
				}
			}
		}
		
		adjList.remove(v);
		return true;
	}

	@Override
	public Set<Town> vertexSet() {
		return adjList.keySet();
	}

    @Override
    public ArrayList<String> shortestPath(Town source, Town dest) {
        ArrayList<String> path = new ArrayList<>();
        dijkstraShortestPath(source);
        Town cur = dest;
        while (cur != null && prev.get(cur) != null) {
            Town p = prev.get(cur);
            Road e = getEdge(p, cur);
            path.add(0,
                p.getName() + " via " + e.getName() +
                " to " + cur.getName() + " " + e.getWeight() + " mi"
            );
            cur = p;
        }
        return path;
    }




	@Override
	public void dijkstraShortestPath(Town source) {
		distances = new HashMap<>();
	    prev = new HashMap<>();
	    Set<Town> visited = new HashSet<>();
	
	    for (Town t : vertexSet()) {
	        distances.put(t, Integer.MAX_VALUE);
	        prev.put(t, null);
	    }
	    distances.put(source, 0);
	
	    while (visited.size() < vertexSet().size()) {
	        Town u = null;
	        int best = Integer.MAX_VALUE;
	        for (Town t : vertexSet()) {
	            if (!visited.contains(t) && distances.get(t) < best) {
	                best = distances.get(t);
	                u = t;
	            }
	        }
	        if (u == null) break;
	        visited.add(u);
	
	        for (Road e : adjList.get(u)) {
	            Town v = e.getSource().equals(u) ? e.getDestination() : e.getSource();
	            if (visited.contains(v)) continue;
	            int nd = distances.get(u) + e.getWeight();
	            if (nd < distances.get(v)) {
	                distances.put(v, nd);
	                prev.put(v, u);
	            }
	        }
	    }
	}
	  
}

