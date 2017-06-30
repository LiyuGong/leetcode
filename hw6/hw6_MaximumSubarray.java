package leet_hw1;

/**
 * 53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * @author liyugong
 *
 */
public class hw6_MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length ==0){
			return 0;
		}
		//dp[i] represesnts the largest sum ending at index i
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for(int i = 1; i<nums.length; i++){
			dp[i] = nums[i] + (dp[i-1] < 0? 0: dp[i-1]);
			max = Math.max(dp[i], max);
		}
		return max; 
    }
	public static void main(String[] args){
		hw6_MaximumSubarray a = new hw6_MaximumSubarray();
	
		System.out.println(a.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
}
