package leet_hw1;

import java.util.*;

/** #494
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 * 
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * @author liyugong
 *
 */
public class hw1_targetSum {
	// public int findTargetSumWays(int[] nums, int S) {
	// int subtotal = 0;
	// return findTargetSumWays(nums, S, 0, 1, subtotal)+findTargetSumWays(nums,
	// S, 0, -1, subtotal);
	// }
	//
	// private int findTargetSumWays(int[] nums, int S, int start, int oper, int
	// subtotal){
	// if (subtotal + oper*nums[start] == S && start == nums.length-1) {
	// return 1;
	// }
	// if (subtotal + oper*nums[start] != S && start == nums.length-1 ){
	// return 0;
	// }
	// return findTargetSumWays(nums, S, start + 1, 1, subtotal +
	// oper*nums[start]) +
	// findTargetSumWays(nums, S, start + 1, -1, subtotal + oper*nums[start]);
	// }
	public int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);
	}

	public int subsetSum(int[] nums, int s) {
		int[] dp = new int[s + 1];
		// dp[i] represents the possible ways to get target i
		dp[0] = 1;
		// n represents the candidates value, outer loop over nums because each
		// n can only be used once
		for (int n : nums)
			// calculate dp from the target sum then backwards 
			// update dp[i] that are greater than or equal to current n
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 31, 18, 39, 33, 33, 15, 36, 50, 8, 47, 21, 29, 24, 39, 23, 44, 22, 33 };
		int[] nums2 = {1,1,1,1,1};
		hw1_targetSum a = new hw1_targetSum();
		System.out.println(a.findTargetSumWays(nums, 11));
		System.out.println(a.findTargetSumWays(nums2, 3));
	}
}
