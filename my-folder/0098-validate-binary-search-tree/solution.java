/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean check(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;
        return (root.val > minVal && root.val < maxVal) && check(root.left, minVal, root.val) && check(root.right, root.val, maxVal);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
