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
        int minIndex = -1;
        int value;


        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;


        while(true){
            minIndex = -1;
            value = Integer.MAX_VALUE;

            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null && lists[i].val<value){
                    minIndex = i;
                    value = lists[i].val;
                }
            }


            if(minIndex == -1){
                break;
            }
            curr.next = lists[minIndex];
            curr=curr.next;
            lists[minIndex] = lists[minIndex].next;


        }

        return dummy.next;
    }
}
