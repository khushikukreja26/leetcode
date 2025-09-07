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
        if(headA == null || headB == null ) return null;

        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;

            if(tempA == tempB) return tempA;

            if(tempA == null) tempA = headB;
            if(tempB == null) tempB = headA;

        }
        return tempA;
    }
}