package structures;

import structures.ArrayList;
import structures.LinkedList;

public abstract class Graph<T> {
	private ArrayList<LinkedList<T>> vertices;
	
	public Graph() {
		vertices = new ArrayList<LinkedList<T>>();
	}
	
	public void addVertex(T value) {
		if(!containsVertex(value)) {
			vertices.add(new LinkedList<T>(value));
		} else {
			System.out.println("Graph already contains vertex: " + value.toString());
		}
	}
	
	public boolean containsVertex(T value) {
		for(LinkedList<T> el: vertices) {
			if(el.get(0).equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public abstract void addEdge(T v1, T v2) ;

}
