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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null ) 
            return head;
        ListNode temp = head, prev = null;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        k %= len;
        if(k == 0)
            return head;
        head = rotateRight(head, k-1);
        temp = head;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.next = head;
        head = temp;
        return head;
    }
}
