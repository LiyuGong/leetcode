package leet_hw1;

/**
 * 63. Unique Paths II

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 * @author liyugong
 *
 */
public class hw7_UniquePath2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null) return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(m <= 0 || n <= 0 || obstacleGrid[0][0] == 1) return 0;
		
		int[] dp = new int[m];
		dp[0] = 1;
		for(int k = 1; k < m;k++){
			dp[k] = (obstacleGrid[k][0] == 1 || dp[k-1] == 0)? 0: 1;
		}
		for(int i = 1; i < n; i++){
			dp[0] = (obstacleGrid[0][i] == 1 || dp[0] == 0)? 0: 1;
			for(int j = 1; j < m; j++){
				dp[j] = (obstacleGrid[j][i] == 1)? 0: dp[j-1] + dp[j];
			}
		}
	
        return dp[m-1] ;
    }
}
