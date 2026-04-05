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
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node root = node;
        dfsToFillMap(root,map);
        for(Map.Entry<Node,Node> entry : map.entrySet()){
            addConnection(entry.getKey(),map);
        }

        return map.get(root);
 
    }

    public void dfsToFillMap(Node root,Map<Node,Node> map){
        if(root==null){
            return;
        }
        if(map.containsKey(root)){
            return;
        }
        map.put(root,new Node(root.val));
        for(int i=0;i<root.neighbors.size();i++){
            dfsToFillMap(root.neighbors.get(i),map);
        }
    }

    public void addConnection(Node root,Map<Node,Node> map){

        Node n = map.get(root);
        for(int i=0;i<root.neighbors.size();i++){
            n.neighbors.add(map.get(root.neighbors.get(i)));    
        }
    }

}