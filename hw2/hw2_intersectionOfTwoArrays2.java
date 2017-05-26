package leet_hw1;

/**
 * #350. Intersection of Two Arrays II Add to List
 * DescriptionHintsSubmissionsSolutions Total Accepted: 63036 Total Submissions:
 * 142209 Difficulty: Easy Contributor: LeetCode Given two arrays, write a
 * function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: Each element in the result should appear as many times as it shows in
 * both arrays. The result can be in any order. Follow up: What if the given
 * array is already sorted? How would you optimize your algorithm? What if
 * nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * use two pointer to go through two array
 * 
 * @author liyugong
 *
 */
public class hw2_intersectionOfTwoArrays2 {
	 HashMap<Integer,Integer> unique1 = new HashMap<Integer,Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int n : nums1) {
			if(unique1.containsKey(n)) unique1.put(n,unique1.get(n)+1);
			else unique1.put(n,1);
		}
		for (int m : nums2) {
			if (unique1.containsKey(m) && unique1.get(m) >0) {
				res.add(m);
				unique1.put(m,unique1.get(m)-1);
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
