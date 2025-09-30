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
    int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode build(int[] postorder, int inStart, int inEnd) {
        if(inStart > inEnd) return null;
        int rootVal = postorder[--postIndex];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderMap.get(rootVal);
        root.right = build(postorder, inIndex+1, inEnd);
        root.left = build(postorder, inStart, inIndex-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length;
        for(int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return build(postorder, 0, inorder.length-1);
    }
}
