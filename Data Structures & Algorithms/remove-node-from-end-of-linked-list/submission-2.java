class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge case where we remove the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer n+1 steps ahead
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // second is now at the node before the one to be deleted
        second.next = second.next.next;
        
        return dummy.next;  // Return the new head (could be the same or a new node)
    }
}
