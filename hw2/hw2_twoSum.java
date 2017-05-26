package leet_hw1;

import java.util.HashMap;
import java.util.Map;

/** #1
 *  Two Sum Add to List DescriptionHintsSubmissionsSolutions Total Accepted:
 * 504660 Total Submissions: 1528119 Difficulty: Easy Contributor: LeetCode
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author liyugong
 *
 */
public class hw2_twoSum {
	public int[] twoSum(int[] nums, int target) {
		// the map stores key: value -> value need to get to target: value index
		Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!mymap.containsKey(nums[i]))
				mymap.put(target - nums[i], i);
			else {
				return new int[] { mymap.get(nums[i]), i };
			}
		}
		return new int[2];
	}
}
