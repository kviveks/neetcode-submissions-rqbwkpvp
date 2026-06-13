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

        dfs(node,nodeMap);

        for(Map.Entry<Node,Node> entry : nodeMap.entrySet()){
            Node original = entry.getKey();
            Node newNode = entry.getValue();

            for(Node n : original.neighbors){
                newNode.neighbors.add(nodeMap.get(n));
            }
        }

        return nodeMap.get(node);
    }

    public void dfs(Node node,Map<Node,Node> nodeMap){

        if(node==null || nodeMap.containsKey(node)){
            return;
        }

        nodeMap.put(node,new Node(node.val));

        for(Node neigh : node.neighbors){
            dfs(neigh,nodeMap);
        }
    }
}