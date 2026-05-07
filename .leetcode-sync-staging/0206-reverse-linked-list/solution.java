/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverse(ListNode node, ListNode prev) {
        if(node == null)
            return null;
        ListNode next = node.next;
        node.next = prev;
        ListNode res = reverse(next, node);
        return (res == null) ? node : res;
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}
