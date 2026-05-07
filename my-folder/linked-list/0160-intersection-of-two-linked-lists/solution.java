/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int l1 = 0, l2 = 0;
        ListNode tempA = headA;
        while(tempA != null) {
            l1++;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while(tempB != null) {
            l2++;
            tempB = tempB.next;
        }
        int diff = Math.abs(l1-l2);
        tempA = headA;
        tempB = headB;
        if(l1 < l2) {
            while(diff > 0) {
                diff--;
                tempB = tempB.next;
            }
        } else if(l1 > l2) {
            while(diff > 0) {
                diff--;
                tempA = tempA.next;
            }
        }
        while(tempA != null && tempB != null) {
            if(tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}
