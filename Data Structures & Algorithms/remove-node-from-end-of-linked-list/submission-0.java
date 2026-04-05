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
    1 - > 2 - > 3 - > 4

 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        int count = 0; //4
        while(node!=null){
            count++;
            node = node.next;
        }

        node = head;

        if(count-n == 0){
            return head.next;
        }

        for(int i = 1;i<=(count-n-1);i++){
            node = node.next;
        }

        node.next = node.next.next;
        return head;


    }
}
