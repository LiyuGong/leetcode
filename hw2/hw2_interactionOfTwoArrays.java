package leet_hw1;

import java.util.*;

/**
 * #349 . Intersection of Two Arrays Add to List
 * DescriptionHintsSubmissionsSolutions Total Accepted: 85973 Total Submissions:
 * 183724 Difficulty: Easy Contributor: LeetCode Given two arrays, write a
 * function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 * @author liyugong
 *
 */
public class hw2_interactionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> unique1 = new HashSet<Integer>();
		HashSet<Integer> res = new HashSet<Integer>();
		for (int n : nums1) {
			unique1.add(n);
		}
		for (int m : nums2) {
			if (unique1.contains(m)) {
				res.add(m);
			}
		}
		int[] out = new int[res.size()];
		int j = 0;
		for (int n : res) {
			out[j] = n;
			j += 1;
		}
		return out;
	}
}
