package leet_hw1;

import java.util.*;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number
 * (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2, 3] ]
 * 
 * @author liyugong
 *
 */

public class hw1_combinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combinationSum(new ArrayList<>(), new ArrayList<Integer>(), candidates, target, 0);
	}

	// this function updates the result list
	private List<List<Integer>> combinationSum(List<List<Integer>> result, List<Integer> cur, int[] candidates,
			int target, int start) {
		if (target == 0) {
			// copy cur and add to result
			result.add(new ArrayList<Integer>(cur));
			return result;
		}
		if (target < 0) {
			return result;
		}
		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
			cur.add(candidates[i]);
			combinationSum(result, cur, candidates, target - candidates[i], i);
			cur.remove(cur.size() - 1);
		}
		return result;
	}
}
