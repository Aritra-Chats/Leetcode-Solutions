/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node DFS(Node node, Map<Node, Node> vis) {
        if(vis.containsKey(node))
            return vis.get(node);
        Node clone = new Node(node.val);
        vis.put(node, clone);
        for(Node neighbor : node.neighbors) 
            clone.neighbors.add(DFS(neighbor, vis));
        return clone;
    }
    public Node cloneGraph(Node node) {
        if(node  == null)
            return null;
        return DFS(node, new HashMap<>());
    }
}
