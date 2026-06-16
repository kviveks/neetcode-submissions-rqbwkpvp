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
        Map<Node,Node> copyMap = new HashMap<>();
        Node curr = head;
        createMap(curr,copyMap);

        curr = head;

        while(curr!=null){
            Node newNode = copyMap.get(curr);
            newNode.next = copyMap.get(curr.next);
            newNode.random = copyMap.get(curr.random);
            curr=curr.next;
        }

        return copyMap.get(head);

    }

    public void createMap(Node node,Map<Node,Node> copyMap){
        while(node!=null){
            copyMap.put(node, new Node(node.val));
            node=node.next;
        }
    }
}
