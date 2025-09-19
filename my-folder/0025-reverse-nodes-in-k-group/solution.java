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
    public ListNode reverse(ListNode head) {
        ListNode temp = head, prev = null;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head, prev = null, startIndex = head;
        while(temp != null) {
            count++;
            if(count == k) {
                ListNode next = temp.next;
                temp.next = null;
                if(prev != null) prev.next = reverse(startIndex);
                else head = reverse(startIndex);
                count = 0;
                prev = startIndex;
                startIndex.next = next;
                startIndex = next;
                temp = next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
