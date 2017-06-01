package leet_hw1;
/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
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
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(isAncester(root, p) && isAncester(root,q)){
			if(isAncester(root.left, p) && isAncester(root.left,q)){
				root = root.left;
			}
			else if(isAncester(root.right, p) && isAncester(root.right,q)){
				root = root.right;
			}
			else{
				return root;
			}
		}
		return root;
		
	 }
	 public boolean isAncester(TreeNode root, TreeNode p){
		 if(root == null){
			 return false;	
		 }
		 if(root == p)
			 return true;
		 return isAncester(root.left, p) || isAncester(root.right,p);
	 }
	 public static void main(String[] args){
			hw3_LowestCommonAncestorofaBinarySearchTree a = new hw3_LowestCommonAncestorofaBinarySearchTree();
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
			System.out.print(a.lowestCommonAncestor(b, h, f).val);
		}
}
