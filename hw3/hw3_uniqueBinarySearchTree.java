package leet_hw1;

/**
 * 96. Unique Binary Search Trees
Total Accepted: 117880
Total Submissions: 291064
Difficulty: Medium
Contributor: LeetCode
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author liyugong
 *
 */
public class hw3_uniqueBinarySearchTree {
	public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return numTree2(n, dp);
    }
    public int numTree2(int n,int[] dp){
        if(dp[n]!=0)
            return dp[n];
        int out = 0;
        for(int i = 0; i < n; i++){
            out += numTree2(i,dp)*numTree2(n-i-1,dp);
        }
        dp[n] = out;
        return out;
    }
}
