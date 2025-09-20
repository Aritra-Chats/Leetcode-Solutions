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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> elems = new ArrayList<>();
        if(root == null) return elems;
        elems.addAll(inorderTraversal(root.left));
        elems.add(root.val);
        elems.addAll(inorderTraversal(root.right));
        return elems;
    }
}
