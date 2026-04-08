/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    public void dfs(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        dfs(node.left,sb);
        dfs(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dfs1(deque);
    }

    public TreeNode dfs1(Deque<String> deque){
        String val = deque.removeFirst();


        if(val.equals("null")){
            return null;
        }


        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfs1(deque);
        node.right = dfs1(deque);

        return node;
    }



}
