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
    int counter = 0;
    int answer = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }
    public void inorder(TreeNode root, int k) {
        if(root == null) return;
        inorder(root.left, k);
        counter++;
        if(counter == k) {
            answer = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
