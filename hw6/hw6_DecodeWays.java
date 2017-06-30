package leet_hw1;

/**
 * 91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * @author liyugong
 *
 */
public class hw6_DecodeWays {
	//dp[i] represents the combination at ith character
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		if(s.charAt(0) == '0') return 0;
		
		int[] dp = new int[s.length()+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i<dp.length; i++){
			int pre = Integer.parseInt(s.substring(i-2, i));
			//if valid there are three conditions
			//10
			//01
			//24
			if(pre > 0 && pre <= 26){
				if      (s.charAt(i-1) == '0') dp[i] = dp[i-2];
				else if (s.charAt(i-2) == '0') dp[i] = dp[i-1];
				else                           dp[i] = dp[i-1] + dp[i-2];
			}			
			//invalid three cases but two can be combined
			//70
			//72
			//00
			else{
				if(s.charAt(i-1) == '0') return 0;
				dp[i] = dp[i-1];
			}
		}
		return dp[dp.length-1];
	} 
	public static void main(String[] args){
		hw6_DecodeWays a = new hw6_DecodeWays();
		System.out.print(a.numDecodings("10"));
	}
}
