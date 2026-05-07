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
        if(root == null) return;
        if(level == result.size()) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        levelize(level+1, root.left, result);
        levelize(level+1, root.right, result);
    }
    public void zigzag(List<List<Integer>> result) {
        int n = result.size();
        for(int i = 0; i < n; i++) {
            if(i % 2 != 0) {
                int len = result.get(i).size();
                for(int j = 0; j < len/2; j++) {
                    int temp = result.get(i).get(j);
                    result.get(i).set(j, result.get(i).get(len - 1 - j));
                    result.get(i).set(len - 1 - j, temp);
                }
            }
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelize(0, root, result);
        zigzag(result);
        return result;
    }
}
