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

        //---Recursice---
        /*List<Integer> elems = new ArrayList<>();
        if(root == null) return elems;
        elems.addAll(postorderTraversal(root.left));
        elems.addAll(postorderTraversal(root.right));
        elems.add(root.val);
        return elems;*/

        //---Iterative---
        //--- 2 Stacks ---
        /*List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> preOrderStack = new Stack<>();
        Stack<TreeNode> postOrderStack = new Stack<>();
        preOrderStack.push(root);
        while(!preOrderStack.isEmpty()) {
            TreeNode temp = preOrderStack.pop();
            postOrderStack.push(temp);
            if(temp.left != null)
                preOrderStack.push(temp.left);
            if(temp.right != null)
                preOrderStack.push(temp.right);
        }
        while(!postOrderStack.isEmpty()) {
            result.add(postOrderStack.pop().val);
        }
        return result;*/

        // --- 1 Stack ---
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null, curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode peek = stack.peek();
                if(peek.right != null && lastVisited != peek.right) {
                    curr = peek.right;
                } else {
                    result.add(peek.val);
                    lastVisited = stack.pop();
                }
            }
        }
        return result;
    }
}
