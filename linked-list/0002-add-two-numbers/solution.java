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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2, dummy = new ListNode(0), tail = dummy;
        int carry = 0;
        while(t1 != null && t2 != null) {
            int val = t1.val + t2.val + carry;
            if(val > 9) {
                carry = 1;
                val %= 10;
            } else 
                carry = 0;
            tail.next = new ListNode(val);
            tail = tail.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1 != null) {
            int val = t1.val + carry;
            if(val > 9) {
                carry = 1;
                val %= 10;
            } else
                carry = 0;
            tail.next = new ListNode(val);
            tail = tail.next;
            t1 = t1.next;
        }
        while(t2 != null) {
            int val = t2.val + carry;
            if(val > 9) {
                carry = 1;
                val %= 10;
            } else
                carry = 0;
            tail.next = new ListNode(val);
            tail = tail.next;
            t2 = t2.next;
        }
        if(carry > 0) 
            tail.next = new ListNode(carry);
        return dummy.next;
    }
}
