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
    TreeNode start; 
    private boolean search(TreeNode node, TreeNode exclude, int key) {
        if(node == null) return false;
        if(node.val == key && node != exclude) return true;
        if(key < node.val) return search(node.left, exclude, key);
        else return search(node.right, exclude, key);
    }
    private boolean hasTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(search(start, root, k-root.val)) return true;
        return hasTarget(root.left, k) || hasTarget(root.right, k);
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        start = root;
        return hasTarget(root, k);
    }
}
