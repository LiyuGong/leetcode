package leet_hw1;

/**
 * #162. Find Peak Element 
 * Total Accepted: 109203 
 * Total Submissions: 296826
 * Difficulty: Medium
 *  Contributor: LeetCode 
 *  A peak element is an element that is
 * greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * @author liyugong
 *
 */
public class hw2_findPeakElement {
	public int findPeakElement(int[] num) {
		int l = 0, r = num.length - 1;
		while (l < r) {
			int m = l + ((r - l) >>> 1);
			// Compare middle element with its neighbors (if neighbors exist)
			if ((m == 0 || num[m - 1] < num[m]) && (m == num.length - 1 || num[m + 1] < num[m])) {
				return m;
			}

			// If its left neighbor is greater than it
			// then left half must have a peak element
			if (m > 0 && num[m - 1] > num[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}
	public static void main(String[] args){
		hw2_findPeakElement a = new hw2_findPeakElement();
		int[] b = new int[]{5,4,7};
		System.out.print(a.findPeakElement(b));
	}
}
