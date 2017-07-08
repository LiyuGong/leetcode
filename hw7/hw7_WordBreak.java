package leet_hw1;

import java.util.HashSet;
import java.util.List;

/**
 * 139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 * @author liyugong
 *
 */
public class hw7_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < i; j++){
				//split current substring into all possible combinations. if one of them works break out try next substring
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
				}
			}
		}
        return dp[n];
    }
}
