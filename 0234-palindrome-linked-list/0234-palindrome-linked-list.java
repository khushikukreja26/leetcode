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
    //reverse function
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next=prev;
            prev = temp;
            temp=front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        //Step1: finding the middle part
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step 2: Reverse the second half of the list
        ListNode newHead = reverse(slow.next);

        //Step3: Comparing the two lists
        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }

            first= first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
}