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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.right != null) {
                TreeNode toRemove = root.right;
                while(toRemove.left != null) 
                    toRemove = toRemove.left;
                root.val = toRemove.val;
                root.right = deleteNode(root.right, toRemove.val);
            } else if(root.left != null) {
                TreeNode toRemove = root.left;
                while(toRemove.right != null) 
                    toRemove = toRemove.right;
                root.val = toRemove.val;
                root.left = deleteNode(root.left, toRemove.val);
            } else {
                return null;
            }
        } else if(key < root.val) 
            root.left = deleteNode(root.left, key);
        else 
            root.right = deleteNode(root.right, key);
        return root;
    }
}
