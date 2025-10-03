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
    private boolean checkBST(TreeNode root, long min, long max) {
        if(root == null) return true;
        return (root.val > min && root.val < max) && checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
    private Map<Integer, TreeNode> map;
    public TreeNode canMerge(List<TreeNode> trees) {
        map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(TreeNode tree : trees) {
            map.put(tree.val, tree);
            if(tree.left != null) children.add(tree.left.val);
            if(tree.right != null) children.add(tree.right.val);
        }
        TreeNode root = null;
        for(TreeNode tree : trees) {
            if(!children.contains(tree.val)) root = tree;
        }
        if(root == null) return null;
        if(!merge(root, root)) return null;
        if(map.size() > 1) return null;
        if(!checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) return null;
        return root;
    }
    private boolean merge(TreeNode child, TreeNode root) {
        if(child == null) return true;
        if(map.containsKey(child.val) && map.get(child.val) != root) {
            TreeNode node = map.get(child.val);
            if(node.left != null && child.left != null || node.right != null && child.right != null) return false;
            if(node.left != null) child.left = node.left;
            if(node.right != null) child.right = node.right;
            map.remove(child.val);
        }
        return merge(child.left, root) && merge(child.right, root);
    }
}
