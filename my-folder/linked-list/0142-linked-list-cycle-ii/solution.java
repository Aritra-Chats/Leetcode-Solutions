/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode hare = head;
        ListNode tortoise = head;
        boolean hasLoop = false;
        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise) {
                hasLoop = true;
                break;
            }
        }
        if(!hasLoop)
            return null;
        tortoise = head;
        while(tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return tortoise;
    }
}
