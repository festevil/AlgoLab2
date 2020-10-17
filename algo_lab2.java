package textrileread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class algo_lab2 {

	public static void mainmethod(String filepath, int[] hosparray) {
		// No of vertices
		int v = NodeNumberFind.Nodenum(filepath);
		boolean nodearray[] = new boolean[v];
		for (int b = 0; b < v; b++) {
			nodearray[b] = false;
		}
		for (int hospind = 0; hospind < hosparray.length; hospind++) {
			nodearray[hosparray[hospind]] = true;
		}

		// Adjacency list for storing which vertices are connected
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		// Reading of the data
		// Variable 1 = first column
		// Variable 2 = second column
		boolean found = false;

		Scanner x;
		int a = 0;
		int b = 0;
		try {
			x = new Scanner(new File(filepath));
			while (!x.hasNextInt()) {
				x.nextLine();
			}

			while (x.hasNext() && !found) {
				a = x.nextInt();
				b = x.nextInt();

				addEdge(adj, a, b);
			}
		} catch (Exception e) {

		}
		

		int source = 0;
		printShortestDistance(adj, source, v, nodearray);
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

	private static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, int s, int v, boolean[] nodearr) {
		int x = 0;
		int pred[] = new int[v];
		int dist[] = new int[v];
		int dest = BFS(adj, s, v, pred, dist, nodearr);
		if (dest == -1) {
			System.out.println("Given source and destination" + "are not connected");
			return;
		}
		

// LinkedList to store path 
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = dest;
		path.add(crawl);
		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}

// Print distance 
		System.out.println("Shortest path length is: " + dist[dest]);

// Print path 
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("alog_write_to.txt", true);
			System.out.println("Path is ::");
			for (int i = path.size() - 1; i >= 0; i--) {
				System.out.print(path.get(i) + " ");

				myWriter.write(path.get(i) + " ");

			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	// a modified version of BFS that stores predecessor
	// of each vertex in array pred
	// and its distance from source in array dist
	private static int BFS(ArrayList<ArrayList<Integer>> adj, int src, int v, int pred[], int dist[], boolean[] nodear) {
		// a queue to maintain queue of vertices whose
		// adjacency list is to be scanned as per normal
		// BFS algorithm using LinkedList of Integer type
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// boolean array visited[] which stores the
		// information whether ith vertex is reached
		// at least once in the Breadth first search
		boolean visited[] = new boolean[v];

		// initially all vertices are unvisited
		// so v[i] for all i is false
		// and as no path is yet constructed
		// dist[i] for all i set to infinity
		for (int i = 0; i < v; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}

		// now source is first to be visited and
		// distance from source to itself should be 0
		visited[src] = true;
		dist[src] = 0;
		queue.add(src);

		// bfs Algorithm
		while (!queue.isEmpty()) {
			int u = queue.remove();
			for (int i = 0; i < adj.get(u).size(); i++) {
				if (visited[adj.get(u).get(i)] == false) {
					visited[adj.get(u).get(i)] = true;
					dist[adj.get(u).get(i)] = dist[u] + 1;
					pred[adj.get(u).get(i)] = u;
					queue.add(adj.get(u).get(i));

					// stopping condition (when we find
					// our destination)
					if (nodear[adj.get(u).get(i)]) {
						return adj.get(u).get(i);						
					}
				}
			}
		}
		return -1;
	}
}
