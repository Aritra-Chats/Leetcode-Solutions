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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        if(n == length) {
            head = head.next;
            return head;
        }
        int removePos = length-n-1;
        temp = head;
        if(removePos <= 0 && length == 1) 
            return null;
        while(removePos > 0) {
            removePos--;
            temp = temp.next;
        }
        if(temp.next != null) temp.next = temp.next.next;
        return head;
    }
}
