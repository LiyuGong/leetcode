package leet_hw1;

/**
 * #35. Search Insert Position Add to List DescriptionHintsSubmissionsSolutions
 * Total Accepted: 168543 
 * Total Submissions: 427535 
 * Difficulty: Easy
 * Contributor: LeetCode 
 * Given a sorted array and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. 
 * [1,3,5,6], 5 → 2 
 * [1,3,5,6], 2 → 1 
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author liyugong
 *
 */
public class hw2_searchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (target < A[0])
			return 0;
		if (target > A[A.length - 1])
			return A.length;
		int low = 0, high = A.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (A[mid] == target)
				return mid;
			else if (A[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}
}
