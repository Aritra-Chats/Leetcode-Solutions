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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode construct(int[] preorder, int left, int right) {
        if(index >= preorder.length) return null;
        if(preorder[index] > left && preorder[index] < right) {
            TreeNode root = new TreeNode(preorder[index++]);
            root.left = construct(preorder, left, root.val);
            root.right = construct(preorder, root.val, right);
            return root;
        }
        return null;
    }
}
