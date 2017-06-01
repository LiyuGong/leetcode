package leet_hw1;

/**
 * 
 * #112. Path Sum 
 * Total Accepted: 159537 
 * Total Submissions: 474577 
 * Difficulty: Easy 
 * Contributor: LeetCode 
 * Given a binary tree and a sum, determine if the tree has a
 * root-to-leaf path such that adding up all the values along the path equals
 * the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,              
 *            5
 *            / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1 
 *      return true, as there exist a root-to-leaf path 5->4->11->2
 * which sum is 22.
 * 
 * @author liyugong
 *
 */
public class hw3_pathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return hasPathSum(root, sum, 0);
    }
	private boolean hasPathSum(TreeNode root, int target, int cur){
		if(root.left == null && root.right == null){
			if(cur + root.val != target){
				return false;
			}
			return true;
		}
		if(root.left != null && root.right == null)
		    return hasPathSum(root.left, target, cur + root.val);
		if(root.right != null && root.left == null)
		    return hasPathSum(root.right, target, cur + root.val);
		return hasPathSum(root.left, target, cur + root.val) || hasPathSum(root.right, target, cur + root.val);
	}
	public static void main(String[] args){
		hw3_pathSum a = new hw3_pathSum();
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(8);
		TreeNode e = new TreeNode(11);
		TreeNode f = new TreeNode(13);
		TreeNode g = new TreeNode(400);
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
		System.out.print(a.hasPathSum(b, 413));
	}
}
