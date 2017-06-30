package leet_hw1;
import java.util.*;
/**
 * 322. Coin Change

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 * @author liyugong
 *
 */
public class hw6_CoinChange {
	int[] dp;
	
	public int numcoin(int[] coins, int target){
		if(target < 0) return -1;
		if(target == 0) return 0;
		
		dp = new int[target+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		//i represents the target
		for(int i = 1; i < target+1; i++){
			int cnt = Integer.MAX_VALUE;
			for(int j = 0; j < coins.length; j++){
				if(coins[j] <= i ){
					//if previous target has possible combination and current combination is smaller then update
					cnt = (dp[i-coins[j]] != -1 && dp[i-coins[j]]+1 < cnt)? dp[i-coins[j]]+1: cnt;
				}
			}
			//if no cnt update then keep -1.
			dp[i] = cnt==Integer.MAX_VALUE? -1:cnt;
		}
		return dp[target];
	}
	public static void main(String[] args){
		hw6_CoinChange a = new hw6_CoinChange();
		System.out.print(a.numcoin(new int[]{5,7,9},81));
	}
}
