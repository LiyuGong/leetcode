package leet_hw1;
/**
 * #235 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w 
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 *      _______6______
 *     /              \
 *   ___2__          ___8__
 *  /      \        /      \
 * 0      _4       7       9
 *        /  \
 *       3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
 * since a node can be a descendant of itself according to the LCA definition.
 * @author liyugong
 */

public class hw3_LowestCommonAncestorofaBinarySearchTree {
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		while (isAncester(root, p) && isAncester(root, q)) {
//			if (isAncester(root.left, p) && isAncester(root.left, q)) {
//				root = root.left;
//			} else if (isAncester(root.right, p) && isAncester(root.right, q)) {
//				root = root.right;
//			} else {
//				return root;
//			}
//		}
//		return root;
//
//	}
//
//	public boolean isAncester(TreeNode root, TreeNode p) {
//		if (root == null) {
//			return false;
//		}
//		if (root == p)
//			return true;
//		return isAncester(root.left, p) || isAncester(root.right, p);
//	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}
}
