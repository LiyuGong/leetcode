package leet_hw1;
import java.util.*;
/**
 * #354. Russian Doll Envelopes 
 * Total Accepted: 18813 
 * Total Submissions: 58891 
 * Difficulty: Hard 
 * Contributor:
 * LeetCode 
 * You have a number of envelopes with widths and heights given as a
 * pair of integers (w, h). One envelope can fit into another if and only if
 * both the width and height of one envelope is greater than the width and
 * height of the other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside
 * other)
 * 
 * Example: Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of
 * envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 * @author liyugong
 *
 */
public class hw2_RussianDollEnvelopes {
	 public int maxEnvelopes(int[][] envelopes) {
         if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) {
                 return 0;
         }

         // Ascend on width and descend on height if width are same.
         Arrays.sort(envelopes, new Comparator<int[]>() {
                 @Override
                 public int compare(int[] e1, int[] e2) {
                         if (e1[0] != e2[0]) {
                                 return Integer.compare(e1[0], e2[0]);
                         }

                         // if width is the same, order by height
                         return Integer.compare(e2[1], e1[1]);
                 }
         });

         // use Longest Increasing Subsequence on height
         int dp[] = new int[envelopes.length];
         int len = 0;
         for (int[] envelope : envelopes) {
                 int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
                 if (index < 0) {
                         index = -(index + 1); // If not found, binarySearch returns (-(insertion point) - 1)
                         // The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element in the range greater than the key, or toIndex if all elements in the range are less than the specified key. 
                 }
                 dp[index] = envelope[1];
                 if (index == len) {
                         len++;
                 }
         }
         return len;
 }
}
