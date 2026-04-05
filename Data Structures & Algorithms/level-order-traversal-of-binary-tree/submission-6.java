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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Deque<TreeNode> pq = new ArrayDeque<>();
        pq.addLast(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!pq.isEmpty()){
            int size = pq.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode node = pq.removeFirst();
                if(node.left!=null){
                    pq.addLast(node.left);
                }
                if(node.right!=null){
                    pq.addLast(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
        }

        return res;
    }
}
