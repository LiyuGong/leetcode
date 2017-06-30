package leet_hw1;

/**
 * 72. Edit Distance

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 * @author liyugong
 *
 */
public class hw6_EditDistance {
	public int minDistance(String word1, String word2) {
		if(word1 == null && word2 == null) return 0;
        if(word1 == null || word1.length() == 0) return word2.length();
        if(word2 == null || word2.length() == 0) return word1.length();

        int n1 = word1.length();
        int n2 = word2.length();
        
        //put word1 horizontally
        //sweep across the grid(n1 + 1)x(n2 + 1) horizontally
        //so dp[i] represent the vertical bar: word2 -> the current edit distance between word2[1:i] and word1[1:current row]
        int[] dp = new int[n2 + 1];
        //initialize dp[]
        for(int k = 1; k< n2+1; k++){
        	dp[k] = k;
        }
        
        //going horizontally
        for(int i = 0; i < n1; i++){
        	//previous dp[0]
            int topleft = i;
            //current dp[0]
            dp[0] = i + 1;
            
        	for(int j = 1; j <= n2; j++){
        		int temp = dp[j];
        		if(word1.charAt(i) != word2.charAt(j-1)){
        			//if word1[i] != word2[j-1] then dp[j] = min(left+2, top+1, topLeft+1)
        			dp[j] = Math.min(dp[j]+1, Math.min(dp[j-1]+1,topleft+1));
        		}
        		else{
        			dp[j] = Math.min(dp[j]+1, Math.min(dp[j-1]+1,topleft));
        		}
        		topleft = temp;
        	}
        }
        
        return dp[n2];
    }
	public static void main(String[] args){
		hw6_EditDistance a = new hw6_EditDistance();
		System.out.print(a.minDistance(null, null));
	}
}
