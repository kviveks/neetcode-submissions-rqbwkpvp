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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode second = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast is null, it means we're removing the head
        if (fast == null) {
            return head.next;
        }

        // Move both fast and second pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return head;
    }
}
