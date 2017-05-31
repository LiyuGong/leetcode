package leet_hw1;

/**
 * #367. Valid Perfect Square Add to List DescriptionHintsSubmissionsSolutions
 * Total Accepted: 40615 
 * Total Submissions: 107003 
 * Difficulty: Easy 
 * Contributor: LeetCode 
 * Given a positive integer num, write a function which returns True if
 * num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16 Returns: True 
 * 
 * Example 2:
 * 
 * Input: 14 Returns: False
 * 
 * @author liyugong
 *
 */
public class hw2_isPerfectSquare {
	public boolean isPerfectSquare(int num) {
		long start = 0;
		long end = num;
		long mid = (start + end) / 2;
		while (end - start >= 0) {
			
			if ((mid * mid) == num)
				return true;
			else if ((mid * mid) > num){
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
			mid = (start + end) / 2;
			
		}
		return false;
	}
}
