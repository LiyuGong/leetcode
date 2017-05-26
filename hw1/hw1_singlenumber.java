package leet_hw1;

/** #136
 * Single Number Add to List DescriptionHintsSubmissionsSolutions Total
 * Accepted: 213033 Total Submissions: 395709 Difficulty: Easy Contributor:
 * LeetCode Given an array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author liyugong
 *
 */
public class hw1_singlenumber {
	public int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int a = nums[0];
		for (int i = 1; i < nums.length; i++) {
			a = a ^ nums[i];
		}
		return a;
	}

	public static void main(String[] args) {
		hw1_singlenumber c = new hw1_singlenumber();
		int[] a = { 1, 2, 3, 1, 2, 3, 7, 7, 8 };
		int[] b = { 1, 1, 1, 1, 1, 1, 2 };
		System.out.println(c.singleNumber(a));
		System.out.println(c.singleNumber(b));
	}
}
