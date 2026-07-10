/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int count = 0;
        if(root.val == p.val || root.val == q.val) count++;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left != null) {
            if(left.val == Integer.MIN_VALUE) count++;
            else return left;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(right != null) {
            if(right.val == Integer.MIN_VALUE) count++;
            else return right;
        }
        if(count == 0) return null;
        else if(count == 1) return new TreeNode(Integer.MIN_VALUE);
        else return root;
    }
}
