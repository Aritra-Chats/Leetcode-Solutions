/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            Node node = new Node(temp.val);
            nodeMap.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            Node copy = nodeMap.get(temp);
            copy.next = (temp.next == null)? null : nodeMap.get(temp.next);
            copy.random = (temp.random == null)? null : nodeMap.get(temp.random);
            temp= temp.next;
        }
        return nodeMap.get(head);
    }
}
