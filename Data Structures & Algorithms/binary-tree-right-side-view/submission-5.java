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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root,res);
        return res;    
    }

    public void bfs(TreeNode root,List<Integer> res){
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            return;
        }
        queue.addLast(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int value = 0;
            for(int i = 1;i<=size;i++){
                TreeNode node = queue.removeFirst();
                value = node.val;
                if(node.left!=null)
                queue.addLast(node.left);
                if(node.right!=null)
                queue.addLast(node.right);
            }
            res.add(value);
        }
    }
}
