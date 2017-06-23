package leet_hw1;
import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * @author liyugong
 *
 */
public class hw5_GraphValidTree {
	
	public boolean validTree(int n, int[][] edges){
		int[] root = new int[n];
		Arrays.fill(root, -1);
		
		for(int[] edge: edges){
			int root0 = find(root, edge[0]);
			int root1 = find(root, edge[1]);
			if(root0 == root1) return false;
			root[edge[0]] = edge[1];
		}
		
		return n == edges.length+1;
	}
	
	
	private int find(int[] root, int node){
		while(root[node] != -1){
			node = root[node];
		}
		return node;
	}
	public static void main(String[] args){
		int[][] edge1 = {{0,1},{0,2},{0,3},{1,4}};
		int[][] edge2 = {{0,1},{1,2},{2,3},{4,5},{5,6}};
		hw5_GraphValidTree a = new hw5_GraphValidTree();
		System.out.print(a.validTree(7, edge2));
	}
}
