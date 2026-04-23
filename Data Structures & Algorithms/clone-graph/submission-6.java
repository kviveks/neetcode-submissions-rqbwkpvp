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
        dfs(node,copyMap);


        for(Map.Entry<Node,Node> entry : copyMap.entrySet()){
            Node original = entry.getKey();
            Node newNode = entry.getValue();

            for(Node n : original.neighbors){
                newNode.neighbors.add(copyMap.get(n));
            }
        }

        return copyMap.get(node);
        
    }


    public void dfs(Node node,Map<Node,Node> copyMap){
        if(node==null || copyMap.containsKey(node)){
            return;
        }

        copyMap.put(node,new Node(node.val));

        for(Node n : node.neighbors){
            dfs(n,copyMap);
        }
    }
}