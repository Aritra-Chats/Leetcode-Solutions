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
    private int max = 0;
    public int gain(TreeNode root) {
        if(root == null) return 0;
        int left_gain = Math.max(0, gain(root.left));
        int right_gain = Math.max(0, gain(root.right));
        max = Math.max(max, root.val+left_gain+right_gain);
        return root.val + Math.max(left_gain, right_gain);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = root.val;
        int finalCheck = gain(root);
        max = Math.max(max, finalCheck);
        return max;
    }
}
