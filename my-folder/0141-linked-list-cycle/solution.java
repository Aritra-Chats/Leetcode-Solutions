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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode hare = head.next;
        ListNode tortoise = head;
        while(hare != null && hare.next != null) {
            if(tortoise == hare)
                return true;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return false;
    }
}
