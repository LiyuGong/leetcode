package leet_hw1;

import java.util.*;

/**
 * #300. Longest Increasing Subsequence Add to List Total Accepted: 74748 Total
 * Submissions: 196796 Difficulty: Medium Contributor: LeetCode Given an
 * unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author liyugong
 *
 */
public class hw2_longestIncreasingSequence {
	// public int lengthOfLIS(int[] nums) {
	// if(nums.length == 0 || nums == null) return 0;
	// return lengthOfLIS(nums,0,nums[0]-1000,0,new ArrayList<>());
	// }
	// public int lengthOfLIS(int[] nums, int start, int pre, int len,
	// ArrayList<Integer> cur){
	// if(start>=nums.length){
	// return len;
	// }
	// if(nums[start]<=pre){
	// return lengthOfLIS(nums,start+1,pre,len, cur);
	// }
	// int maxLen = len;
	// for(int i = start; i<nums.length; i++){
	// if(nums[i]>pre){
	// cur.add(nums[i]);
	// int b = lengthOfLIS(nums,i+1,nums[i],len+1,new ArrayList<>(cur));
	// if(b>maxLen)
	// maxLen = b;
	// cur.remove(cur.size()-1);
	// }
	// }
	// return maxLen;
	// }

	// o(N^2)
	// public int lengthOfLIS(int[] nums) {
	// //dp[i] represents the longest sequence end at position i-1
	// int[] dp = new int[nums.length];
	// int max = 0;
	// for(int i = 0; i < nums.length; i++) {
	// int sub = 0;
	// for(int j = 0; j < i; j++){
	// if(nums[i] > nums[j]){
	// if( 1 + dp[j] > sub){
	// sub = 1 + dp[j];
	// }
	// }
	// }
	// if(sub == 0)
	// dp[i]=1;
	// else dp[i] = sub;
	// if(dp[i]>max) max = dp[i];
	// }
	//
	// return max;
	// }
	public int lengthOfLIS(int[] nums) {
		// dp[i] represents the current last element of a sequence of length i+1
		int[] dp = new int[nums.length];
		// current # sequence of different length
		int len = 0;

		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}

		return len;
	}

	class SequenceMember implements Comparable<SequenceMember> {
		SequenceMember prev;
		int value; // index of the sequence, need to evaluate using a[value]

		public SequenceMember(SequenceMember prev, int value) {
			this.prev = prev;
			this.value = value;
		}

		@Override
		public int compareTo(SequenceMember o) {
			return Integer.compare(this.value, o.value);
		}

		@Override
		public String toString() {
			if (this.prev == null) {
				return "[value=" + value + "]";
			}
			return "[prev=" + this.prev.value + ", value=" + this.value + "]";
		}
	}

	public int lengthOfLIS2(int[] nums) {
		List<SequenceMember> dp = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			SequenceMember cur = new SequenceMember(null, nums[i]);
			int index = Collections.binarySearch(dp, cur);
			if (index < 0) {
				index = -(index + 1);
			}
			if (index > 0) {
				cur.prev = dp.get(index - 1);
			}
			if (index >= dp.size()) {
				dp.add(cur);
			} else {
				dp.set(index, cur);
			}
		}

		if (!dp.isEmpty()) {
			SequenceMember cur = dp.get(dp.size() - 1);
			while (cur != null) {
				System.out.println(cur);
				cur = cur.prev;
			}
		}
		return dp.size();
	}

	public static void main(String[] args) {
		hw2_longestIncreasingSequence a = new hw2_longestIncreasingSequence();
		System.out.print(a.lengthOfLIS(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
				20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37 }));
		// System.out.print(a.lengthOfLIS(new int[]{4,10,4,2,3,8}));
	}
}
