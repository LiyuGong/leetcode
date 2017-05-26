package leet_hw1;
import java.util.*;
/**
 * #300. Longest Increasing Subsequence Add to List
 *  Total Accepted: 74748 
 *  Total Submissions: 196796 
 *  Difficulty: Medium 
 *  Contributor: LeetCode 
 *  Given an unsorted array of
 * integers, find the length of longest increasing subsequence.
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
//	public int lengthOfLIS(int[] nums) {
//		if(nums.length == 0 || nums == null) return 0;
//        return lengthOfLIS(nums,0,nums[0]-1000,0,new ArrayList<>());
//    }
//    public int lengthOfLIS(int[] nums, int start, int pre, int len, ArrayList<Integer> cur){
//        if(start>=nums.length){
//            return len;
//        }
//        if(nums[start]<=pre){
//            return lengthOfLIS(nums,start+1,pre,len, cur);
//        }
//        int maxLen = len;
//        for(int i = start; i<nums.length; i++){
//        	if(nums[i]>pre){
//        		cur.add(nums[i]);
//        		int b = lengthOfLIS(nums,i+1,nums[i],len+1,new ArrayList<>(cur));        	
//        		if(b>maxLen)
//        			maxLen = b;
//        		cur.remove(cur.size()-1);
//        	}
//        }
//        return maxLen;
//    } 
	public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
    public static void main(String[] args){
    	hw2_longestIncreasingSequence a = new hw2_longestIncreasingSequence();
    	System.out.print(a.lengthOfLIS(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37}));
//    	System.out.print(a.lengthOfLIS(new int[]{4,10,4,2,3,8}));
    }
}
