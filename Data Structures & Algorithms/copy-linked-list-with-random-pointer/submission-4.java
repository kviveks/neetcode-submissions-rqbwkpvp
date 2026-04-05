/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> nodeMap = new HashMap<>();

        copyMap(nodeMap,head);


        for(Map.Entry<Node,Node> entry : nodeMap.entrySet()){
            entry.getValue().next = nodeMap.get(entry.getKey().next);
            entry.getValue().random = nodeMap.get(entry.getKey().random);
        }

        return nodeMap.get(head);
        
    }

    public void copyMap(Map<Node,Node> nodeMap,Node head){
        Node curr = head;

        while(curr!=null){
            nodeMap.put(curr,new Node(curr.val));
            curr = curr.next;
        }
    }
}
