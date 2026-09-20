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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // Temporarily disconnect the group
            kth.next = null;

            // Reverse the group
            ListNode reversed = reverse(groupStart);

            // Connect the previous part to the reversed group
            prevGroupEnd.next = reversed;

            // Connect the reversed group to the next part
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;


    }


    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode getKthNode(ListNode head,int k){
        ListNode temp = head;
        for(int i = 1;i<=k;i++){
            if(temp == null){
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }
}
