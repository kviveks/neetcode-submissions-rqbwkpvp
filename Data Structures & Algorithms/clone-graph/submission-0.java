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
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }
        Node startNode = node;
        dfs(node);

        for(Map.Entry<Node,Node> entry : map.entrySet()){
            Node currNode = entry.getKey();
            Node newNode = entry.getValue();

            for(int i = 0; i< currNode.neighbors.size();i++){
                newNode.neighbors.add(map.get(currNode.neighbors.get(i)));
            }

        }   

        return map.get(startNode); 
    }

    public void dfs(Node node){

        if (map.containsKey(node)) return;

        map.put(node,new Node(node.val));

        for(int i = 0 ; i< node.neighbors.size(); i++){
            dfs(node.neighbors.get(i));
        }
    }


}