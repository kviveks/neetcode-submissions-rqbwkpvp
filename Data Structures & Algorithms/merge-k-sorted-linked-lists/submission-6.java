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
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;


        while(true){
            int minIndex = -1;
            int currentMin = Integer.MAX_VALUE;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null && currentMin > lists[i].val){
                    minIndex = i;
                    currentMin = lists[i].val;
                }
            }

            if(minIndex == -1){
                break;
            }else{
                curr.next = lists[minIndex];
                curr = curr.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }

        return dummy.next;
    }
}
