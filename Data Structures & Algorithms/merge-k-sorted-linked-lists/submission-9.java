class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (true) {
            int minIndex = -1;
            int currentMin = Integer.MAX_VALUE;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null &&
                    (minIndex == -1 || lists[i].val < currentMin)) {
                    minIndex = i;
                    currentMin = lists[i].val;
                }
            }

            if (minIndex == -1) {
                break;
            }

            curr.next = lists[minIndex];
            curr = curr.next;
            lists[minIndex] = lists[minIndex].next;
        }

        return dummy.next;
    }
}