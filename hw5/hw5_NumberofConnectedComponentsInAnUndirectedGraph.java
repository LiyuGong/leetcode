package leet_hw1;

import java.util.*;

/**
 * leetcode: 323
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:

    0          3
    |          |
    1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

    0           4
    |           |
    1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * @author liyugong
 *
 */
public class hw5_NumberofConnectedComponentsInAnUndirectedGraph {
	int[] root;
	int[] weight;
	public int countComponents(int n, int[][] edges) {
		root = new int[n];
		for(int k = 0; k < n; k++){
			root[k] = k;
		}
		weight = new int[n];
		Arrays.fill(weight, 1);
		for(int[] edge: edges){
			union(edge[0], edge[1]);
		}
		HashSet<Integer> myset = new HashSet<>();
		for(int i: root){
			myset.add(find(i));
		}
		
		return myset.size();
	}
	private int find(int node){
		while(root[node] != node){
			root[node] = root[root[node]];
			node = root[node];		
		}
		return node;
	}
	private void union(int node0, int node1){
		int root0 = find(node0);
		int root1 = find(node1);
		if(root0 != root1){
			if(weight[root0] > weight[root1]){
				root[root1] = root0;
				weight[root0] += weight[root1];
			}
			else{
				root[root0] = root1;
				weight[root1] += weight[root0];
			}
		}
	}
	public static void main(String[] args){
		int[][] edge1 = {{0,1},{1,2},{3,4}};
		int[][] edge2 = {{0,1},{1,2},{2,3},{3,4}};
		int[][] edge3 = {{0,1},{1,2},{2,3},{3,4},{4,0},{3,5},{0,3},{6,7},{8,9}};
		hw5_NumberofConnectedComponentsInAnUndirectedGraph a = new hw5_NumberofConnectedComponentsInAnUndirectedGraph();
		System.out.print(a.countComponents(10, edge3));
	}
}
