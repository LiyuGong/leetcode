package leet_hw1;

/**
 * 474. Ones and Zeroes (medium)

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:
The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 * @author liyugong
 *
 */
public class hw7_OnesAndZeros {
	public int findMaxForm(String[] strs, int m, int n) {
		//memo represents the maximum number of strings using i 0s and j 1s
		int[][] memo = new int[m+1][n+1];

		//loop through string array
		for(String s: strs){
			int numZ = 0, numO = 0;
			for(char c: s.toCharArray()){
				if(c == '1') numO += 1;
				else numZ += 1;
			}
			
			//if previous #string st previous 01 limits + current string is larger than current limit then update
			//update from the right bottom corner so no double counting
			//
			for(int i = m; i >= numZ; i--){
				for(int j = n; j >= numO; j--){
					memo[i][j] = Math.max(memo[i][j], memo[i-numZ][j-numO]+1);
				}
			}
		}
        return memo[m][n];
    }
	public static void main(String[] args){
		hw7_OnesAndZeros a = new hw7_OnesAndZeros();
		System.out.print(a.findMaxForm(new String[]{"10", "001", "111001","1","0","0","0","0","0","0","0","0","0","0","0","0","0"},5,3));
	}
}
