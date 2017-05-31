package leet_hw1;

/**
 * #34. Search for a Range 
 *  Total Accepted: 132284 
 *  Total Submissions: 424262 
 *  Difficulty: Medium 
 *  Contributor:LeetCode Given an array of integers sorted in ascending order, find the
 * starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author liyugong
 *
 */
public class hw2_searchForARange {
//	 public int[] searchRange(int[] nums, int target) {
//         if (nums == null || nums.length == 0) {
//                 return new int[] { -1, -1 };
//         }
//         int[] ret = new int[] { -1, -1 };
//         int left = 0, right = nums.length - 1;
//         while (left < right) {
//                 int mid = left + (right - left) / 2;
//                 if (nums[mid] < target) {
//                         left = mid + 1;
//                 } else {
//                         right = mid;
//                 }
//         }
//         if (nums[left] != target) {
//                 return ret;
//         }
//         ret[0] = left;
//
//         right = nums.length - 1;
//         while (left < right) {
//                 int mid = left + (right - left) / 2 + 1;
//                 if (nums[mid] > target) {
//                         right = mid - 1;
//                 } else {
//                         left = mid;
//                 }
//         }
//         ret[1] = right;
//         return ret;
// }
	public int[] searchRange(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while(low<=high){
			int m = low + (high-low)/2;
			if(nums[m] >= target){
				high = m-1;
			}
			else{
				low = m+1;
			}
		}
		if(low >= nums.length || nums[low] != target){
			return new int[]{-1,-1};
		}
		int low2 = low;
		high = nums.length-1;
		while(low2<=high){
			int m = low2 + (high-low2)/2;
			if(nums[m] > target){
				high = m-1;
			}
			else{
				low2 = m+1;
			}
		}
		return new int[]{low, high};
	}
	public static void main(String[] args){
		hw2_searchForARange a = new hw2_searchForARange();
		int[] b = new int[]{8};
		System.out.println(a.searchRange(b, 9)[0]);
		System.out.print(a.searchRange(b, 9)[1]);
	}
}
