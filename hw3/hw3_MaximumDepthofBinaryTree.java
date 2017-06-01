package leet_hw1;

/**
 * #104. Maximum Depth of Binary Tree 
 * Total Accepted: 237678 
 * Total Submissions: 457019 
 * Difficulty: Easy 
 * Contributor: LeetCode Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author liyugong
 *
 */
public class hw3_MaximumDepthofBinaryTree {
	 public int maxDepth(TreeNode root){
	        if(root ==null) return 0;
	        if(root.left == null && root.right == null){
	            return 1;
	        }
	        if( root.left == null){
	            return 1+maxDepth(root.right);
	        }
	        if( root.right == null){
	            return 1+maxDepth(root.left);
	        }
	        return Math.max(1+maxDepth(root.right),1+maxDepth(root.left));
	    }
}
