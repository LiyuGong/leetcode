package leet_hw1;

import java.util.TreeSet;

/**
 * #363. Max Sum of Rectangle No Larger Than K Add to List
 * Total Accepted: 12544 
 * Total Submissions: 38607 
 * Difficulty: Hard 
 * Contributor: LeetCode 
 * Given a non-empty 2D matrix
 * matrix and an integer k, find the max sum of a rectangle in the matrix such
 * that its sum is no larger than k.
 * 
 * Example: Given matrix = [ [1, 0, 1], [0, -2, 3] ] k = 2 The answer is 2.
 * Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number
 * no larger than k (k = 2).
 * 
 * Note: The rectangle inside the matrix must have an area > 0. What if the
 * number of rows is much larger than the number of columns?
 * 
 * @author liyugong
 *
 */
public class hw2_MaxSumofRectangleNoLargerThanK {
	 public int maxSumSubmatrix(int[][] matrix, int target) {
         int row = matrix.length;
         if (row == 0) {
                 return 0;
         }
         int col = matrix[0].length;
         int m = Math.min(row, col);
         int n = Math.max(row, col);
         // indicating sum up in every row or every column
         boolean colIsBig = col > row;
         int res = Integer.MIN_VALUE;
         for (int startRow = 0; startRow < m; startRow++) {
                 // sums[i] is presum of matrix[0 ~ i], from startRow to endRow
                 int[] sums = new int[n];
                 for (int endRow = startRow; endRow < m; endRow++) {
                         int sum = 0;
                         TreeSet<Integer> set = new TreeSet<>();
                         set.add(0);
                         // traverse every column/row and sum up
                         for (int k = 0; k < n; k++) {
                                 sums[k] += colIsBig ? matrix[endRow][k] : matrix[k][endRow];
                                 sum += sums[k];
                                 // binary search previous sum to get possible result
                                 // sums[i] + delta = sums[j], delta <= target
                                 // sums[i] = sums[j] - delta >= sums[j] - target
                                 Integer subres = set.ceiling(sum - target);
                                 if (null != subres) {
                                         res = Math.max(res, sum - subres);
                                         if (res == target) {
                                                 return target;
                                         }
                                 }
                                 set.add(sum);
                         }
                 }
         }
         return res;
 }
}
