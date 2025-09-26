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
    public void mapify(TreeNode root, List<Integer> result, int level) {
        if(root == null) return;
        if(level >= result.size()) {
            result.add(root.val);
        }
        mapify(root.right, result, level+1);
        mapify(root.left, result, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        mapify(root, result, 0);
        return result;
    }
}
