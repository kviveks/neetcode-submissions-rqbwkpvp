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
        return levelOrder(root);
    }

    public List<Integer> levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if(root==null){
            return res;
        }

        Deque<TreeNode> pq = new ArrayDeque<>();
        pq.addLast(root);


        while(!pq.isEmpty()){
            int size = pq.size();
            int value = 0;
            for(int i = 1;i<=size;i++){
                TreeNode temp = pq.removeFirst();
                value = temp.val;
                if(temp.left!=null){
                    pq.addLast(temp.left);
                }
                if(temp.right!=null){
                    pq.addLast(temp.right);
                }
            }
            res.add(value);

        }

        return res;


    }
}
