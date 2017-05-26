package leet_hw1;

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ]
 * 
 * @author liyugong
 *
 */
public class hw1_combinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combinationSum2(new ArrayList<>(), new ArrayList<>(), candidates, target, 0);
	}

	private List<List<Integer>> combinationSum2(List<List<Integer>> result, List<Integer> cur, int[] candidates,
			int target, int start) {
		if (target == 0) {
			result.add(new ArrayList<>(cur));
			return result;
		}
		if (target < 0) {
			return result;
		}
		for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			cur.add(candidates[i]);
			combinationSum2(result, cur, candidates, target - candidates[i], i + 1);
			cur.remove(cur.size() - 1);
		}
		return result;
	}
}
