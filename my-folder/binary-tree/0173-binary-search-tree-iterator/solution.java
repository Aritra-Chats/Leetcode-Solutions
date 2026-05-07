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
class BSTIterator {
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    Stack<TreeNode> stack;

    private void pushLeft(TreeNode root) {
        TreeNode temp = root;
        while(temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }
    
    public int next() {
        TreeNode temp = stack.pop();
        if(temp.right != null) 
            pushLeft(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
