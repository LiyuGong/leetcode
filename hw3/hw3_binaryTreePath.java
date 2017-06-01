package leet_hw1;

import java.util.*;

/**
 * #257. Binary Tree Paths
Total Accepted: 106080
Total Submissions: 284522
Difficulty: Easy
Contributor: LeetCode
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 * @author liyugong
 *
 */
public class hw3_binaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePaths(root, new ArrayList<String>(), Integer.toString(root.val));
        
    }
	private List<String> binaryTreePaths(TreeNode root, List<String> result, String cur){
		if(root.left == null && root.right == null){
			result.add(cur);
		}
		else if(root.left ==null && root.right != null)
			binaryTreePaths(root.right, result, cur+"->"+Integer.toString(root.right.val));
		else if(root.right ==null && root.left != null)
			binaryTreePaths(root.left, result, cur+"->"+Integer.toString(root.left.val));
		else{
			binaryTreePaths(root.left, result, cur+"->"+Integer.toString(root.left.val));
			binaryTreePaths(root.right, result, cur+"->"+Integer.toString(root.right.val));
		}
		return result;
	}
	public static void main(String[] args){
		hw3_binaryTreePath a = new hw3_binaryTreePath();
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(8);
		TreeNode e = new TreeNode(11);
		TreeNode f = new TreeNode(13);
		TreeNode g = new TreeNode(4);
		TreeNode h = new TreeNode(7);
		TreeNode i = new TreeNode(2);
		TreeNode j = new TreeNode(1);
		b.left = c;
		b.right = d;
		c.left = e;
		c.right = null;
		d.left = f;
		d.right = g;
		e.left = h;
		e.right = i;
		f.left = null;
		f.right =null;
		g.left = null;
		g.right = j;
		h.left = null;
		h.right =null;
		i.left = null;
		i.right =null;
		j.left = null;
		j.right =null;
		System.out.print(a.binaryTreePaths(b));
	}
}
