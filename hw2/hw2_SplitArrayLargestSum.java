package leet_hw1;

/**
 * #410. Split Array Largest Sum 
 * Total Accepted: 10804 
 * Total Submissions: 30385 
 * Difficulty: Hard 
 * Contributor:LeetCode 
 * Given an array which consists of non-negative integers and an
 * integer m, you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * Note: If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000 1 ≤ m ≤ min(50, n) Examples:
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 * 
 * @author liyugong
 *
 */
public class hw2_SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
        long sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(max, nums[i]);
        }

        if (m == 1) {
                return (int) sum;
        }

        // binary search
        long l = max;
        long r = sum;
        while (l <= r) {
                long mid = l + ((r - l) >>> 1);
                if (isValid(mid, nums, m)) {
                        // count <= m
                        r = mid - 1;
                } else { // count > m
                        l = mid + 1;
                }
        }
        return (int) l;
}

// If true, count <= m
private boolean isValid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
                total += num;
                if (total > target) {
                        total = num;
                        count++;
                        if (count > m) {
                                return false;
                        }
                }
        }
        return true;
}

}
