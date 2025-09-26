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
    class Node {
        int data, row, col;
        Node(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }

    public void matrify(TreeNode root, List<Node> matrix, int row, int col) {
        if(root == null) return;
        matrix.add(new Node(root.val, row, col));
        matrify(root.left, matrix, row+1, col-1);
        matrify(root.right,  matrix, row+1, col+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int prevCol = Integer.MIN_VALUE;
        List<Node> matrix = new ArrayList<>();
        matrify(root, matrix, 0, 0);
        Collections.sort(matrix, (a,b) -> {
            if(a.col != b.col) return a.col - b.col;
            if(a.row != b.row) return a.row- b.row;
            return a.data - b.data;
        });
        for(Node instance : matrix) {
            if(instance.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = instance.col;
            }
            result.get(result.size()-1).add(instance.data);
        }
        return result;
    }
}
