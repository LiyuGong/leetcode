package leet_hw1;

import java.util.Arrays;

/**
 * 62. Unique Paths
 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 * @author liyugong
 *
 */
public class hw7_UniquePaths {
	public int uniquePaths(int m, int n) {
		if(m <= 0 || n <= 0) return 0;
		if(m == 1 || n == 1) return 1;

		int[] dp = new int[m];
		Arrays.fill(dp, 1);
        for( int i = 1; i < n; i++){
        	for( int j = 1; j < n; j++){
        		dp[j] = dp[j] + dp[j-1];
        	}
        }
        return dp[m-1];
    }
}