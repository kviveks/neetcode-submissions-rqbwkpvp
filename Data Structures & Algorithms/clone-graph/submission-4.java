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
        Map<Node,Node> nodeMap = new HashMap<>();
        createCopyNode(nodeMap,node);

        for(Map.Entry<Node,Node> entry : nodeMap.entrySet()){
            addConnection(entry.getKey(),nodeMap);
        }

        return nodeMap.get(node);

    }

    public void createCopyNode(Map<Node,Node> nodeMap,Node node){
        if(node==null || nodeMap.containsKey(node)){
            return; 
        }

        nodeMap.put(node, new Node(node.val));

        for(Node neighbour : node.neighbors){
            createCopyNode(nodeMap,neighbour);
        }
    }

    public void addConnection(Node root,Map<Node,Node> map){

        Node n = map.get(root);
        for(int i=0;i<root.neighbors.size();i++){
            n.neighbors.add(map.get(root.neighbors.get(i)));    
        }
    }


}