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
    public ListNode reverseListRecursive(ListNode head, ListNode prev) {
        if(head == null)
            return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverseListRecursive(next, head);
    }
    public ListNode reverseList(ListNode head) {
        /* ----Iterative---- */
        /* ListNode temp = head, prev = null;
        while(temp !=  null) {
            if(temp.next == null) head = temp;
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return head; */
        /* ----Recursive---- */
        return reverseListRecursive(head, null);
    }
}
