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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        ListNode temp = head;
        ListNode revHead = null;
        while(temp != null) {
            revHead = new ListNode(temp.val, revHead);
            temp = temp.next;
        }
        temp = head;
        while(temp != null && revHead != null) {
            if(temp.val != revHead.val)
                return false;
            temp = temp.next;
            revHead = revHead.next;
        }
        return true;
    }
}
