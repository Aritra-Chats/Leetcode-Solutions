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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode last = head;
        int length = 0;
        while(last.next != null) {
            length++;
            last = last.next;
        }
        length++;
        if(length == 2)
            return head;
        ListNode temp = head;
        ListNode replaceNode = null;
        while(temp != null && length > 1) {
            replaceNode = temp.next;
            temp.next = temp.next.next;
            replaceNode.next = null;
            last.next = replaceNode;
            last = replaceNode;
            length -= 2;
            temp = temp.next;
        }
        return head;
    }
}
