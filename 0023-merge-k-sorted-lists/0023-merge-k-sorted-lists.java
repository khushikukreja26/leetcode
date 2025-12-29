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
    public ListNode mergeKLists(ListNode[] listArray) {
        if (listArray == null || listArray.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode head : listArray) {
            if (head != null) pq.offer(head);
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();

            if (cur.next != null) pq.offer(cur.next);

            temp.next = cur;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
