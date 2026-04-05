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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode curr = result;

        while (true) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }

            if (minIndex == -1) {
                break;
            }

            curr.next = lists[minIndex];
            curr = curr.next;
            lists[minIndex] = lists[minIndex].next;
        }

        return result.next;
    }
}

