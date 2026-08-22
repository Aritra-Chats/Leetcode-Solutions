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
    private void buildPaths(TreeNode root, int sum, int targetSum, List<Integer> currPath, List<List<Integer>> paths) {
        if(root.left == null && root.right == null) {
            if(sum == targetSum)
                paths.add(new ArrayList<>(currPath));
            return;
        }
        if(root == null)
            return;
        if(root.left != null) {
            currPath.add(root.left.val);
            buildPaths(root.left, sum+root.left.val, targetSum, currPath, paths);
            currPath.remove(currPath.size()-1);
        }
        if(root.right != null) {
            currPath.add(root.right.val);
            buildPaths(root.right, sum+root.right.val, targetSum, currPath, paths);
            currPath.remove(currPath.size()-1);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null)
            return paths;
        buildPaths(root, root.val, targetSum, new ArrayList<>(List.of(root.val)), paths);
        return paths;
    }
}
