package graphs;

import java.util.LinkedList;
import java.util.Queue;

class Graph {
	enum State {VISITED, UNVISITED}
	int vertices;
	LinkedList<Integer>[] adjList;
	
	Graph(int vertices) {
		this.vertices = vertices;
		this.adjList = new LinkedList[vertices];
		for(int i=0; i<vertices; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int fromNode, int toNode) {
		adjList[fromNode].add(toNode);
	}
	
	void bfs( int startNode) {
		
		//1. Mark all vertices as non visited
		State visited[] = new State[vertices];
		for(int i=0; i<vertices; i++) {
			visited[i] = State.UNVISITED;
		}
		
		// Create a queue and enqueue the root/starting node in it
		Queue<Integer> q = new LinkedList<Integer>();
		visited[startNode] = State.VISITED;
		q.add(startNode);
		
		// Add and remove from queue based on bfs
		while(!q.isEmpty()) {
			// Get the front element of queue
			Integer node = q.poll();
			System.out.println(node);
			
			if(node!=null) {
				for(Integer n: adjList[node]) {
					if(visited[n] != State.VISITED) {
						q.add(n);
						visited[n] = State.VISITED;
					}
					
				}
			}
		}	
	}
}

public class LearnGraph {

	public static void main(String[] args) {
		
		// https://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
		// TODO Auto-generated method stub
		/*
		 *   Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
		 */
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.bfs(2);

	}

}
