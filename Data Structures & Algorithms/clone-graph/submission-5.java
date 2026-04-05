/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        Map<Node,Node> copyMap = new HashMap<>();
        createCopy(node,copyMap);

        for(Map.Entry<Node,Node> entry : copyMap.entrySet()){
            addConnection(entry.getKey(),copyMap);
        }

        return copyMap.get(node);
    }

    public void createCopy(Node node,Map<Node,Node> copyMap){
        if(node == null || copyMap.containsKey(node)){
            return;
        }

        copyMap.put(node,new Node(node.val));

        for(Node nei : node.neighbors){
            createCopy(nei,copyMap);
        }
    }

    public void addConnection(Node root,Map<Node,Node> map){

        Node n = map.get(root);
        for(int i=0;i<root.neighbors.size();i++){
            n.neighbors.add(map.get(root.neighbors.get(i)));    
        }
    }
}