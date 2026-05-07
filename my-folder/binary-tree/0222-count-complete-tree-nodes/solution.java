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
    class Pair {
        int level;
        int count;
        Pair(int level, int count) {
            this.level = level;
            this.count = count;
        }
    }
    Pair lastLevel;
    public int lastLength(TreeNode root, int level) {
        if(root == null) return -1;
        if(level > lastLevel.level) {
            lastLevel.level = level;
            lastLevel.count = 1;
        } else if(level == lastLevel.level) lastLevel.count++;
        return 1+Math.max(lastLength(root.left, level+1), lastLength(root.right, level+1));
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        lastLevel = new Pair(0, 0);
        int level = lastLength(root, 0)-1;
        int nodes = (int) (Math.pow(2, level+1)-1) +lastLevel.count;
        return nodes;
    }
}
