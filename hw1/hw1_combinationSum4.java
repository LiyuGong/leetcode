package leet_hw1;

import java.util.*;


/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?


 * @author liyugong
 *
 */
public class hw1_combinationSum4 {
	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		// note that nums are all positive numbers and no duplicates
		Arrays.sort(nums);
		// res[i] represent the possible ways to get target i
		int[] res = new int[target + 1];
		res[0] = 1;
		// outer loop fill the res array
		for (int i = 0; i <= target; i++) {
			// inner loop try each individual element add element to previous
			// sum
			for (int num : nums) {
				if (num > i) {
					break;
				}

				res[i] += res[i - num];
			}
		}
		return res[target];
	}
}
