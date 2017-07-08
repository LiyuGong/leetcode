package leet_hw1;
/**
 * 5. Longest Palindromic Substring (medium)

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

 * @author liyugong
 *
 */
public class hw7_LongestPalindromicSubstring {
//	public String longestPalindrome(String s) {
//		if(s == null) return null;
//		int n = s.length();
//		if(n<2) return s;
//		
//        int[][] dp = new int[n][n];
//        int max = 0;
//        int tailIndex = 0;
//        for(int j = 0; j < n; j++){
//        	dp[j][j] = 1;
//        	for(int i = j-1; i >= 0; i--){
//        		if(s.charAt(i) == s.charAt(j)){
//        			if(j - i == 1){
//        				dp[i][j] = 1;
//        				max = Math.max(max, j-i);
//        				tailIndex = j-i == max? j:tailIndex;
//        			}
//        			else if(dp[i+1][j-1] == 1){
//        				dp[i][j] = 1;
//        				max = Math.max(max, j-i);
//        				tailIndex = j-i == max? j:tailIndex;
//
//        			}
//        		}
//        	}
//        }
//        return s.substring(tailIndex-max, tailIndex+1);
//    }
	public String longestPalindrome(String s) {
		if(s == null) return null;
		int n = s.length();
		if(n<2) return s;
		
        int[] dp = new int[n];
        int max = 0;
        int tailIndex = 0;
        for(int j = 0; j < n; j++){
        	int temp = 0;
        	dp[j] = 1;
        	for(int i = j-1; i >= 0; i--){
        		if(s.charAt(i) == s.charAt(j)){
        			if(j - i == 1){
        				temp = dp[i];
        				dp[i] = 1;
        				max = Math.max(max, j-i);
        				tailIndex = j-i == max? j:tailIndex;
        			}
        			else if(temp == 1){	
        				temp = dp[i];
        				dp[i] = 1;
        				max = Math.max(max, j-i);
        				tailIndex = j-i == max? j:tailIndex;

        			}
        			else if(temp != 1){
        				temp = dp[i];
        				dp[i] = 0;
        			}
        		}
        		else{
        			temp = dp[i];
        			dp[i] = 0;

        		}
        	}
        }
        return s.substring(tailIndex-max, tailIndex+1);
    }
	public static void main(String[] args){
		hw7_LongestPalindromicSubstring a = new hw7_LongestPalindromicSubstring();
		System.out.print(a.longestPalindrome("aabaaa"));
	}
}
