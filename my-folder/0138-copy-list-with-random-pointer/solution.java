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
        Node temp = head, dummy = new Node(0), tail = dummy;
        Map<Node, Node> map = new HashMap<>();
        while(temp != null) {
            tail.next = new Node(temp.val);
            tail = tail.next;
            map.put(temp, tail);
            temp = temp.next;
        }
        tail = dummy.next;
        temp = head;
        while(temp != null) {
            tail.random = (temp.random == null) ? null : map.get(temp.random);
            tail = tail.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
