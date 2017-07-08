package leet_hw1;
/**
 * 516. Longest Palindromic Subsequence (medium)

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

 * @author liyugong
 *
 */
public class hw7_LongestPalindromicSubsequence {
//	public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        //dp[i][j] represents the length of palindrome sequence in substring[i,j]
//        int[][] dp = new int[n][n];
//        
//        for(int j = 0; j < n; j++){
//        	//diagonal represents a single letter so length = 1
//        	dp[j][j] = 1;
//        	for(int i = j-1; i >= 0; i--){
//        		if(s.charAt(j) == s.charAt(i)){
//        			//if the start and the end of a substring are the same then length of palindrome = palindrome w/o current start and end +2
//        			dp[i][j] = dp[i+1][j-1] + 2;
//        		}
//        		else{
//        			//if ith and jth characters are different, then either i or j character contributes to a longer parlindrome
//        			//thus max( [i,j-1], [i+1,j])
//        			dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
//        		}
//        		
//        	}
//        }
//        return dp[0][n-1];
//	}
	public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp[i][j] represents the length of palindrome sequence in substring[i,j]
        int[] dp = new int[n];
        
        for(int j = 0; j < n; j++){
        	//pre is previous left bottom 
        	int pre = 0;
        	dp[j] = 1;
        	for(int i = j-1; i >= 0; i--){
        		if(s.charAt(j) == s.charAt(i)){
        			//if the start and the end of a substring are the same then length of palindrome = palindrome w/o current start and end +2

        			int temp = dp[i];
        			dp[i] = pre + 2;
        			pre = temp;
        			
        		}
        		else{
        			//if ith and jth characters are different, then either i or j character contributes to a longer parlindrome
        			//thus max( [i,j-1], [i+1,j]) left and bottom
        			int temp = dp[i];
        			dp[i] = Math.max(dp[i], dp[i+1]);
        			pre = temp;

        		}
        		
        	}

        }
        return dp[0];
	}

	public static void main(String[] args){
		hw7_LongestPalindromicSubsequence a = new hw7_LongestPalindromicSubsequence();
		System.out.print(a.longestPalindromeSubseq("abbcdba"));
	}
}
