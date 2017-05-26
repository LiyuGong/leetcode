package leet_hw1;

import java.util.*;

/** #219
 * Contains Duplicate II Add to List DescriptionHintsSubmissionsSolutions Total
 * Accepted: 106868 Total Submissions: 333711 Difficulty: Easy Contributor:
 * LeetCode Given an array of integers and an integer k, find out whether there
 * are two distinct indices i and j in the array such that nums[i] = nums[j] and
 * the absolute difference between i and j is at most k.
 * 
 * @author liyugong
 *
 */
public class hw1_containsNearbyDuplicate {

	// public boolean containsNearbyDuplicate(int[] nums, int k) {
	// if(k>=nums.length){
	// Set<Integer> cnt = new HashSet<Integer>();
	// for (int i :nums){
	// if(!cnt.add(i)){
	// return true;
	// }
	// }
	// return false;
	// }
	// else{
	// for(int i = 0; i<nums.length-k; i++){
	// for(int j = 1;j<=k;j++){
	// if(nums[i] == nums[i+j]){
	// return true;
	// }
	// }
	// }
	// for(int l = 1; l<k;l++){
	// for(int z = 1;z<=k-l;z++){
	// if(nums[nums.length-k-1+l]==nums[nums.length-k-1+l+z]){
	// return true;
	// }
	// }
	// }
	// return false;}
	// }
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> mySet = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				mySet.remove(nums[i - k - 1]); // 注意删除的element的index
			}
			if (!mySet.add(nums[i])) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9 };
		int[] d = { 1, 1 };
		hw1_containsNearbyDuplicate c = new hw1_containsNearbyDuplicate();
		System.out.println(c.containsNearbyDuplicate(a, 3));
		System.out.println(c.containsNearbyDuplicate(b, 3));
		System.out.println(c.containsNearbyDuplicate(d, 2));
	}
}
