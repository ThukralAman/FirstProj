package graphs;

import javafx.util.Pair;
import linkedlist.IntersectionOfTwoLinkedList;

import java.util.*;

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

	void bfs(int startNode) {
		State visited[] = new State[vertices];
		for(int i=startNode; i<vertices; i++) {
			visited[i] = State.UNVISITED;
		}

		for(int i=startNode; i<vertices; i++) {
			if(visited[i] == State.UNVISITED) {
				bfsUtil(i, visited);
			}
		}

	}
	
	void bfsUtil( int startNode, State[] visited) {
		
		//1. Mark all vertices as non visited

		
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

	void dfs(int startNode) {
		State visited[] = new State[vertices];
		for(int i=startNode; i<visited.length; i++) {
			visited[i] = State.UNVISITED;
		}

		for(int i=startNode; i<vertices; i++) {
			if(visited[i] == State.UNVISITED) {
				dfsUtil(i, visited);
			}
		}

	}

	void dfsUtil(int startNode, State[] visited) {

		// visit the given node and recurse on its adjacent nodes
		System.out.println("Visited Node: " + startNode);
		visited[startNode] = State.VISITED;

		Iterator<Integer> it = adjList[startNode].iterator();
		while(it.hasNext()) {
			int adjNode = it.next();
			if(visited[adjNode] != State.VISITED) {
				dfsUtil(adjNode, visited);
			}
		}
	}
}

class SolveGraphProblems {


	/*
		We check for cycle based on visitedStack and not visited[]
		 See graph image in @link: https://youtu.be/rKQaZuoUR4M?t=4
		 to understand wht visit[] array is not the right way to track cycle

		  Time complexity: O(V+E)
	 */
	boolean hasCyclesUtil(Graph g, int startNode, boolean[] visited, boolean[] visitingStack) {

		if(visitingStack[startNode]) {
			return true;
		}

		visited[startNode] = true;
		visitingStack[startNode] = true;

		Iterator<Integer> it = g.adjList[startNode].iterator();
		while(it.hasNext()) {
			int adjNode = it.next();
			if(!visited[adjNode] || visitingStack[adjNode]) {
				if(hasCyclesUtil(g, adjNode, visited, visitingStack)) {
					return true;
				}
			}
		}
		visitingStack[startNode] = false;
		return false;

	}



	public boolean hasCycles(Graph g, int startNode) {

		// Initialize a visitedBooleanArray to track nodes that are visited
		// Initialize a visitingStack that keeps track of nodes whose adjacent nodes are being visited
		boolean[] visitingStack = new boolean[g.vertices];
		boolean[] visited = new boolean[g.vertices];


		// Call hasCycleUtil for all nodes that have not been visited and return result accordingly
		for(int i=startNode; i<g.vertices; i++) {
			if(visited[i] == false) {
				if(hasCyclesUtil(g, i, visited, visitingStack)) {
					return true;
				}
			}
		}
		return false;
	}

	// ----------------2. Topological Sort -------------------------
	public void topologicalSortUtil(Graph g, int startNode, boolean[] visited, Stack<Integer> sortedStack) {

		// Mark the given node as visited
		visited[startNode] = true;

		// Iterate all adjacent nodes and once all of them have been iterated put the given node in sorted stack
		Iterator<Integer> it = g.adjList[startNode].iterator();
		while(it.hasNext()) {
			Integer adjNode = it.next();
			if(!visited[adjNode]) {
				topologicalSortUtil(g, adjNode, visited, sortedStack);
			}
		}

		sortedStack.push(startNode);
	}

	public void topologicalSort(Graph g, int startNode) {
		boolean[] visited = new boolean[g.vertices];
		Stack<Integer> sortedStack = new Stack<>();

		for(int i=startNode; i< g.vertices; i++) {
			visited[i] = false;
		}

		for(int i= startNode; i<g.vertices; i++) {
			if (!visited[i]) {
				topologicalSortUtil(g, i, visited, sortedStack);
			}
		}

		System.out.println(sortedStack);

	}

	// --------------- 3 Count Islands --------------------------------
	public int countIslands(int[][] m) {
		int countConnectedComponents = 0;

		// create a visited array for nodes in graph
		boolean[][] visited = new boolean[m.length][m[0].length];

		// call dfs/countIslandUtil for the first valid graph node. On its return all subgraph connected nodes will be marked visited
		// iterate over next unvisited node of next disjoint subgraph and again call dfs/countIslandUtil on it.
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				if(m[i][j] ==1 && !visited[i][j]) {
					countIslandUtil(m, i, j, visited);
					countConnectedComponents++;
				}
			}
		}

		return countConnectedComponents;
	}

	public void countIslandUtil(int[][] m, int i, int j, boolean[][] visited) {

		visited[i][j] = true;

		int[] rowDiplacement = {-1, 0, 1, 1, 1, 0, -1, -1};
		int[] colDisplacement = {-1, -1, -1, 0, 1, 1, 1, 0};

		for(int k=0; k<7; k++) {
			if(isDisplacementValid(m, i+rowDiplacement[k], j+colDisplacement[k], visited)) {
				countIslandUtil(m, i+rowDiplacement[k], j+colDisplacement[k], visited);
			}
		}
	}

	public boolean isDisplacementValid(int[][] m, int i, int j, boolean[][] visited) {
		return i>=0 && i<m.length && j>=0 && j<m[0].length && !visited[i][j] && m[i][j]==1;
	}

	// ----------------- 3 END -------------------------------------------

	// -------------- 4) Dijkastra ------------------------



	/*
	Algo: Dijkastra
	1) S = {}
	2) Q = {0,1,2,3,4,5,6,7}
	3) while priorityQueue Q is not empty  {
		vertex u = extractMin(Q)
		S = S Union {u}
		for each vertex v which is (adj[u] && in Q) {
			if dist[v] > dist[u] + w {
				dist[v] = dist[u] + w
				ancestor[v] = u
			}

		}

	}

	References:
	1 - https://www.hackerrank.com/topics/shortest-paths-in-graphs: code works exactly as explained in its video
	2 - gfg: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
	 */
	public int[] dijkastraShortestDistance(int[][] g, int source) {
		// dist[] array stores the shortest distance of vertices from given source vertex
		int[] dist = new int[g.length];

		// Declare a boolean array which indicates if vertex's shortest distance is finalised
		boolean[] spSet = new boolean[g.length];

		// Initialize all shortestDistance for each vertex to infinity
		for(int i=0; i<dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// Set shortest path from source to source = 0
		dist[source] = 0;

		for(int i=0; i<g.length; i++) {
			int u = getMinDistVertex(g, dist, spSet);

			spSet[u] = true;

			for(int v=0; v<g.length; v++) {
				if(!spSet[v] && g[u][v]!=0) {

					dist[v] = dist[v] > dist[u] + g[u][v] ? dist[u] + g[u][v] : dist[v];
					/*if(dist[v] > dist[u] + g[u][v]) {
						dist[v] = dist[u] + g[u][v];
					}*/
				}
			}
		}


		return dist;
	}


	/*
		return the vertex whose distance is minimum out of all vertices which are not in spSet
	 */
	public int getMinDistVertex(int[][] g, int[] dist, boolean[] spSet) {


		int minDist = Integer.MAX_VALUE;
		int minDistVertex = -1;
		for(int i=0; i<g.length; i++) {
			if(!spSet[i] && dist[i] < minDist) {
				minDist = dist[i];
				minDistVertex = i;
			}
		}
		return minDistVertex;
	}

	// --------- Min swap to sort array --------------------------

	public int minSwaps(int[] a) {

		/*


			1) Create pair wise list of given array of form (arr[i], i)
			2) Sort pairwise list based on value of elements in a[] i.e sort on basis of key in pair (arr[i], i) where arr[i] is key
			3) Start searching for cycle starting from 0th index of list containing pairs
				- While searching for cycle keep marking the nodes as visited, so that they are skipped when searching for
				  another cycle in list

				  How to search for cycle ?
				  - create a visited boolean array[] initialized to all false
				  - Iterate over values of pairs to backtrack. If while backtracking you reach a visited node, then it means there is a cycle
				  - For this step refer to youtube video on : minimum swap to sort an array in my personal channel
		 */

		List<Pair<Integer, Integer>> pairList = new ArrayList();

		// Step1
		for(int i=0; i<a.length; i++) {
			Pair p = new Pair(a[i], i);
			pairList.add(p);
		}

		// Step2
		pairList.sort(new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				if(o1.getKey() > o2.getKey()) {
					return -1;
				}else if(o1.getKey() == o2.getKey()) {
					return 0;
				}else {
					return 1;
				}
			}
		});

		// Step3
		int minSwaps = 0;
		boolean[] visited = new boolean[a.length];
		for(int i=0; i<a.length; i++) {
			int j=i;
			int cycleLength =0;

			while(!visited[j]) {
				visited[j] = true;
				j = pairList.get(j).getValue();
				cycleLength++;
			}
			if(cycleLength>1) {
				minSwaps += cycleLength-1;
			}
		}
		return minSwaps;
	}

	// --------------- Min Swap END ---------------------------------

	public void dfs(Graph g, int sourceNode, boolean[] visited, Stack<Integer> st) {
		visited[sourceNode] = true;
		Iterator<Integer> it = g.adjList[sourceNode].iterator();

		while(it.hasNext()) {
			Integer adjNode = it.next();
			if(!visited[adjNode])
			dfs(g, adjNode, visited, st);
		}

		st.push(sourceNode);
	}

	public void transpose(Graph g) {

	}

	public void printSCCs(Graph g, int sourceNode) {
		/*
			// KosaRaju Algo
			Steps:
				1) Do a dfs and maintain visited array and VisitedStack(vertices are pushed in stack by time in decreasing order)
				2) Do a transpose of the graph in O(V+E) time
				3) Do a dfs on the graph picking vertices from created stack in step1. This DFS will result in all SCCs present in graph
		 */

		boolean visited[] = new boolean[g.vertices];
		Stack<Integer> st = new Stack<>();

		for(int i=sourceNode; i<g.vertices; i++) {
			if(!visited[i]) {
				dfs(g, sourceNode, visited, st);
			}
		}
		System.out.println(st);
		transpose(g);
	}
}

public class LearnGraph {

	public static void main(String[] args) {

		SolveGraphProblems obj = new SolveGraphProblems();
		
		// https://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
		// TODO Auto-generated method stub
		/*
		 *   Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
		 */
		/*
		Graph g = new Graph(6);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 0);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
		g.addEdge(5, 3);

		System.out.println("BFS of graph below: ");
		g.bfs(0);
		System.out.println("DFS of Graph Below: ");
		g.dfs(0);
		*/

		// ---------------- 1) Check if directed graph is cyclic --------------------------

		/*
		SolveGraphProblems obj = new SolveGraphProblems();
		Boolean result = obj.hasCycles(g, 0);
		System.out.println("Is graph cyclic: " + result);
		*/

		// -------------- 1 END ---------------------------------

		// ----------------- 2) Toplogical Sort -------------------------------

		/*
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(3, 0);
		g.addEdge(3, 4);
		g.addEdge(4, 5);


		System.out.println("BFS of graph below: ");
		g.bfs(0);


		SolveGraphProblems obj = new SolveGraphProblems();
		Boolean result = obj.hasCycles(g, 0);
		System.out.println("Is graph cyclic: " + result);
		System.out.println("------------ Topological sort-----------");
		obj.topologicalSort(g, 0);

		// ----------------- 2 END -------------------------

		// ---------------- 3) Count islands ---------------------------

		int M[][]=  new int[][] {
				{1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}
		};

		System.out.println("Number of islands is: " + obj.countIslands(M));
		*/

		// -------------------------- 3 END ----------------------------

		// ------------------------ 4) Dijkastra algorithm -----------------

		/*
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
				{4, 0, 8, 0, 0, 0, 0, 11, 0},
				{0, 8, 0, 7, 0, 4, 0, 0, 2},
				{0, 0, 7, 0, 9, 14, 0, 0, 0},
				{0, 0, 0, 9, 0, 10, 0, 0, 0},
				{0, 0, 4, 14, 10, 0, 2, 0, 0},
				{0, 0, 0, 0, 0, 2, 0, 1, 6},
				{8, 11, 0, 0, 0, 0, 1, 0, 7},
				{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};

		SolveGraphProblems obj = new SolveGraphProblems();
		int[] shortestPaths = obj.dijkastraShortestDistance(graph, 0);
		for(int i=0; i<shortestPaths.length; i++) {
			System.out.println("Shortest distance of vertex " + i + " from vertex 0 is " + shortestPaths[i]);
		}
		*/

		// ------------- 4 END --------------------------------

		// ----- 5 Min number of swaps to sort array --------------

		/*
		//int []a = {1, 5, 4, 3, 2};
		int []a = {6, 17, 22, 4, 10};
		//int []a = {1, 2, 3, 4, 5};
		//int []a = {4, 5, 2, 3, 1};
		System.out.println("Min Swaps required: " + obj.minSwaps(a));
		*/

		// --------- 5 END ----------------------------

		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		System.out.println("Following are strongly connected components in given graph ");
		obj.printSCCs(g, 0);


	}

}
