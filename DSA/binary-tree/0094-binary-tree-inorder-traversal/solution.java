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
        
        // ---Morris---
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode next = curr.left;
                while(next.right != null && next.right != curr) 
                    next = next.right;
                if(next.right == null) {
                    next.right = curr;
                    curr = curr.left;
                } else {
                    next.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;


        // ---Iteractive---
        /*List<Integer> elems = new ArrayList<>();
        if(root == null) return elems;
        elems.addAll(inorderTraversal(root.left));
        elems.add(root.val);
        elems.addAll(inorderTraversal(root.right));
        return elems;*/

        // ---Recursive---
        /*List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        List<TreeNode> stack = new ArrayList<>();
        int top = -1;
        TreeNode temp = root;
        while(temp != null) {
            stack.add(temp);
            top++;
            temp = temp.left;
        }
        while(!stack.isEmpty()) {
            temp = stack.remove(top--);
            result.add(temp.val);
            if(temp.right != null) {
                stack.add(temp.right);
                top++;
                temp = temp.right;
                while(temp != null) {
                    temp = temp.left;
                    if(temp == null) continue;
                    stack.add(temp);
                    top++;
                }
            }
        }
        return result;*/
    }
}
