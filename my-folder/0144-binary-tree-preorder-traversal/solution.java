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
    public List<Integer> preorderTraversal(TreeNode root) {

        // ---Recursive---
        /*List<Integer> elems = new ArrayList<>();
        if(root == null) return elems;
        elems.add(root.val);
        elems.addAll(preorderTraversal(root.left));
        elems.addAll(preorderTraversal(root.right));
        return elems;*/

        // ---Iterative---
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        int top = 0;
        while(!stack.isEmpty()) {
            TreeNode temp = stack.remove(top--);
            result.add(temp.val);
            if(temp.right != null) {
                stack.add(temp.right);
                top++;
            }
            if(temp.left != null) {
                stack.add(temp.left);
                top++;
            }
        }
        return result;
    }
}
