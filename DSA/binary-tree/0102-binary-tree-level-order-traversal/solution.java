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
    public void levelize(int level, TreeNode root, List<List<Integer>> result) {
        if(root == null)
            return;
        if(level == result.size()) 
            result.add(new ArrayList<>());
        result.get(level).add(root.val);

        levelize(level+1, root.left, result);
        levelize(level+1, root.right, result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelize(0, root, result);
        return result;
    }
}
