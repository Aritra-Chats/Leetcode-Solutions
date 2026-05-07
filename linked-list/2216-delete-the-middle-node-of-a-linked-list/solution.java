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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        int nodeToRemove = ((length % 2 == 0) ? (length+1)/2 : length/2)-1;
        temp = head;
        while(nodeToRemove > 0) {
            nodeToRemove--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
