package leet_hw1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 547. Friend Circles
Total Accepted: 8433
Total Submissions: 17176
Difficulty: Medium
Contributors:
lkpunisher
There are N students in a class. Some of them are friends, while some are not. 
Their friendship is transitive in nature. 
For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. 
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
 * @author liyugong
 *
 */
public class hw5_FriendCircles {
	int[] root;
	int[] weight;
	
	public int findCircleNum(int[][] M) {
		int n = M.length;
		root = new int[n];
		for(int k = 0; k < n; k++){
			root[k] = k;
		}
		weight = new int[n];
		Arrays.fill(weight, 1);
		
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				if(M[i][j] == 1)
					union(i,j);
			}
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
}
