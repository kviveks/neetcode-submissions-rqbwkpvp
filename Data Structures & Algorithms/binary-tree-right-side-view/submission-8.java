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
        if(root==null){
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            int value = -1;
            for(int i=1;i<=size;i++){
                TreeNode node = queue.removeFirst();
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                if(node.right!=null){
                    queue.addLast(node.right);
                }
                value = node.val;
            }
            res.add(value);
        }
        return res;
    }
}
