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
        TreeNode root;
        int index;
        Pair(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int width = 0;
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size(), minIndex = queue.peek().index, first = 0, last = 0;
            for(int i = 0; i < size; i++) {
                Pair instance = queue.poll();
                int currIndex = instance.index - minIndex;
                if(i == 0) first = currIndex;
                else if(i == size-1) last = currIndex;
                if(instance.root.left != null) queue.offer(new Pair(instance.root.left, 2 * currIndex + 1));
                if(instance.root.right != null) queue.offer(new Pair(instance.root.right, 2 * currIndex + 2));
            }
            width = Math.max(width, last-first+1);
        }
        return width;
    }
}
