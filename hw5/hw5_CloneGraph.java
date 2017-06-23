package leet_hw1;

import java.util.*;

/**
 * 133. Clone Graph

Total Accepted: 109711
Total Submissions: 437340
Difficulty: Medium
Contributor: LeetCode
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 * @author liyugong
 *
 */
class UndirectedGraphNode {
    int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class hw5_CloneGraph {
	HashMap<Integer,UndirectedGraphNode> myMap = new HashMap<>();
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        return clone(node);
    }
	//this function create a copy of the node
	public UndirectedGraphNode clone(UndirectedGraphNode node){
		if(myMap.containsKey(node.label))
			return myMap.get(node.label);
		UndirectedGraphNode graphnode = new UndirectedGraphNode(node.label);
		myMap.put(node.label, graphnode);
		for(UndirectedGraphNode neighbor: node.neighbors){
			graphnode.neighbors.add(clone(neighbor));
		}
		return graphnode;
	}
}
