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


 /*
    1 -> 2 -> 3 -> 4

    1 -> 2 -> 3 -> 4 -> 5


 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;
        ListNode first = head;


        while(second!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2; 
        }

    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }

        return prev;

    }
}
