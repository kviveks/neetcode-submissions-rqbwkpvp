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
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root==null)
            return new ArrayList<>();

        deque.addLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=1;i<=size;i++){
                TreeNode node = deque.removeFirst();
                temp.add(node.val);

                if(node.left!=null)
                    deque.add(node.left);

                if(node.right!=null)
                    deque.add(node.right);
            }
            res.add(temp);
        }

        return res;
    }
}
