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


//  1 -> 2 -> 3
//  4 -> 5 -> 6



class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode rl1 =  reverse(l1);
        // ListNode rl2 =  reverse(l2);

        int carry = 0;
        ListNode result = null;
        ListNode curr = result;

        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            ListNode temp = new ListNode(sum%10);
            if(curr==null){
                result = temp;
                curr = temp;
            }else{
                curr.next = temp;
                curr=curr.next;
            }
            carry = sum/10;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int sum = l1.val+carry;
            ListNode temp = new ListNode(sum%10);
            if(curr==null){
                result = temp;
                curr = temp;
            }else{
                curr.next = temp;
                curr = curr.next;
            }
            carry = sum/10;
            l1=l1.next;
        }

        while(l2!=null){
            int sum = l2.val+carry;
            ListNode temp = new ListNode(sum%10);
            if(curr==null){
                result = temp;
                curr = temp;
            }else{
                curr.next = temp;
                curr = curr.next;
            }
            carry = sum/10;
            l2=l2.next;
        }

        if(carry!=0){
            ListNode temp = new ListNode(carry);
            curr.next = temp;    
        }

        return result;   
    }

    // public ListNode reverse(ListNode head){
    //     ListNode curr = head;
    //     ListNode prev = null;

    //     while(curr!=null){
    //         ListNode temp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = temp;
    //     }

    //     return prev;
    // }
}

