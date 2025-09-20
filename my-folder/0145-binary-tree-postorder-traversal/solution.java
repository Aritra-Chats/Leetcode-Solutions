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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> elems = new ArrayList<>();
        if(root == null) return elems;
        elems.addAll(postorderTraversal(root.left));
        elems.addAll(postorderTraversal(root.right));
        elems.add(root.val);
        return elems;
    }
}
