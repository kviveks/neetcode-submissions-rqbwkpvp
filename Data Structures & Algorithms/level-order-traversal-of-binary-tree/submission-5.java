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
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempRes = new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode temp = queue.removeFirst();
                tempRes.add(temp.val);
                if(temp.left!=null)
                queue.add(temp.left);

                if(temp.right!=null)
                queue.add(temp.right);
            }
            res.add(tempRes);
        }

        return res;    
    }
}
