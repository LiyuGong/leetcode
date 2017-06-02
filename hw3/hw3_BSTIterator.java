package leet_hw1;

import java.util.*;


/**
 * #173. Binary Search Tree Iterator
DescriptionHintsSubmissionsSolutions
Total Accepted: 87383
Total Submissions: 215540
Difficulty: Medium
Contributor: LeetCode
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * @author liyugong
 *
 */


public class hw3_BSTIterator {
	Stack<TreeNode> myStack;

	public hw3_BSTIterator(TreeNode root) {
		myStack = new Stack<TreeNode>();
		while (root != null) {
			myStack.push(root);
			root = root.left;
		}

	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !myStack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode out = myStack.pop();
		TreeNode cur = out;
		if (cur.right != null) {
			cur = cur.right;
			while (cur != null) {
				myStack.push(cur);
				cur = cur.left;
			}
		}
		return out.val;
	}
}
