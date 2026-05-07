/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public void buildParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if(node == null) return;
        parent.put(node, par);
        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null || root.left == null && root.right == null & k > 0) return new ArrayList<>();
        if(k == 0) return new ArrayList<>(List.of(target.val));
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(dist == k) break;
            for(int i = 0; i < size; i++) {
                TreeNode instance = queue.poll();
                for(TreeNode node : new TreeNode[]{instance.left, instance.right, parent.get(instance)
                }) {
                    if(node != null && !visited.contains(node)) {
                        queue.offer(node);
                        visited.add(node);
                    }
                }
            }
            dist++;
        }
        List<Integer> result = new ArrayList<>();
        for(TreeNode instance : queue) result.add(instance.val);
        return result;
    }
}
