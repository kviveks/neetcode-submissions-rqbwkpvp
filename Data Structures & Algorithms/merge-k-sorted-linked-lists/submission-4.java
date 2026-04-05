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
            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            int index = -1;
            for(int i = 0;i<lists.length;i++){
                if(lists[i]!=null && minNode.val>lists[i].val){
                    minNode = lists[i];
                    index = i;
                }
            }

            if(index!=-1){
                curr.next = minNode;
                lists[index] = lists[index].next;
                curr = curr.next;
            }else{
                break;
            }
        }

        return dummy.next;

    }
}
