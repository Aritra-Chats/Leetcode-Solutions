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
    private int dfs(TreeNode root, int currVal) {
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null) 
            return currVal;
        else {
            int sum = 0;
            if(root.left != null)
                sum += dfs(root.left, currVal * 10 + root.left.val);
            if(root.right != null) 
                sum += dfs(root.right, currVal * 10 + root.right.val);
            return sum;
        }
    }
    public int sumNumbers(TreeNode root) {
        return dfs(root, root.val);
    }
}
