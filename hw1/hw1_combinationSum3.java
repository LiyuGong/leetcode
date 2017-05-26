package leet_hw1;

import java.util.*;
/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 * @author liyugong
 *
 */
public class hw1_combinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] candidates = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		return combinationSum3(new ArrayList<>(), new ArrayList<Integer>(), candidates, n, 0, k);
	}

	private List<List<Integer>> combinationSum3(List<List<Integer>> result, List<Integer> cur, int[] candidates,
			int target, int start, int size) {
		if (target < 0 || cur.size() > size) {
			return result;
		}
		if (target == 0 && cur.size() == size) {
			result.add(new ArrayList<Integer>(cur));
			return result;
		}
		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
			cur.add(candidates[i]);
			combinationSum3(result, cur, candidates, target - candidates[i], i + 1, size);
			cur.remove(cur.size() - 1);
		}
		return result;
	}
}
