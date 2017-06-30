package leet_hw1;

/**
 * 221. Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

 * @author liyugong
 *
 */
public class hw6_MaximalSquared {
	public int maximalSquare(char[][] matrix) {
		int x = matrix[0].length;
		int y = matrix.length;
		if(matrix == null || y == 0 || x == 0) return 0;
		int max = 0;
		
		//dp[j] represents the side length of the largest square whose lower right corner is at (j-1 row, current column)
		//sweep horizontally
		//dp[0] is the virtual -1th row added to the top
		int[] dp = new int[y+1];
		int topLeft = 0;
		//move horizontally
		for(int i = 0; i < x; i++){
			for(int j = 1; j <= y; j++){
				int temp = dp[j];
				if(matrix[j-1][i] == '0') dp[j] = 0;
				else{
					//largest square is limited by left, top, top left
					dp[j] = Math.min(dp[j], Math.min(dp[j-1],topLeft)) + 1;
					max = Math.max(max, dp[j]);
				}
				//topLeft represent the "topleft" entry for the next row which is the current dp[j] before updating
				topLeft = temp;
			}
		}
					
        return max*max;
    }
	public static void main(String[] args){	
		char[][] d = new char[][]{{0}};
		
		char[][] b = new char[][]{{'1','0','1','0','0'},
								  {'1','0','1','1','1'},
								  {'1','1','0','0','1'},
								  {'1','0','0','1','0'}};
								  
								  
		
		char[][] c = new char[][]{{'1','0','1','0','0','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','1','1','1','1','0','1','0','0','1','0','1','0','0'},
								  {'1','1','1','1','1','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','0','1','0','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','1','0','0','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','1','1','1','1','0','1','0','0','1','0','1','0','0'},
								  {'1','1','1','1','1','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','0','1','0','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','1','0','0','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','1','1','1','1','0','1','0','0','1','0','1','0','0'},
								  {'1','1','1','1','1','1','0','1','1','1','1','0','1','0','0'},
								  {'1','0','0','1','0','1','0','1','1','1','1','0','1','0','0'},
								  {'1','0','1','0','0','1','0','1','1','1','1','0','1','0','0'},
								  {'1','0','1','1','1','1','0','1','1','1','1','0','1','0','0'},
								  {'1','1','1','1','1','1','0','1','0','0','1','0','1','0','0'},
								  {'1','0','0','1','0','1','0','1','0','0','1','0','1','0','0'}};						  
		
		hw6_MaximalSquared a = new hw6_MaximalSquared();
		System.out.print(a.maximalSquare(c));
	}
}
