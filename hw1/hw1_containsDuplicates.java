package leet_hw1;

import java.util.*;

/** #217
 * Contains Duplicate Add to List DescriptionHintsSubmissionsSolutions
 * Total Accepted: 155909 Total Submissions: 346353 Difficulty: Easy
 * Contributor: LeetCode Given an array of integers, find if the array contains
 * any duplicates. Your function should return true if any value appears at
 * least twice in the array, and it should return false if every element is
 * distinct.
 * 
 * @author liyugong
 *
 */
public class hw1_containsDuplicates {
	// public boolean containsDuplicate(int[] nums){
	// HashMap<Integer,Integer> cnt = new HashMap<Integer,Integer>();
	// for (int i :nums){
	// if(!cnt.containsKey(i)){
	// cnt.put(i, 1);
	// }
	// else if (cnt.get(i)>=1){
	// return true;
	// }
	// }
	// return false;
	// }
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> cnt = new HashSet<Integer>();
		for (int i : nums) {
			if (!cnt.add(i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 2 };
		hw1_containsDuplicates c = new hw1_containsDuplicates();
		System.out.println(c.containsDuplicate(a));
		System.out.println(c.containsDuplicate(b));
	}
}
