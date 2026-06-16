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




 // 1 2 3 4 5 6 7 null


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        int count=0;
        while(fast!=null){
            if(count<=n){
                fast=fast.next;
            }else{
                fast=fast.next;
                slow=slow.next;
            }
            count++;
        }

        slow.next=slow.next.next;

        return dummy.next;

    }
}
