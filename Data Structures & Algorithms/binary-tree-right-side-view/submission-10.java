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
        if(root==null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            int rightValue = 0;
            for(int i=1;i<=size;i++){
                TreeNode temp = deque.removeFirst();
                rightValue = temp.val;
                if(temp.left!=null)
                    deque.addLast(temp.left);

                if(temp.right!=null)
                    deque.addLast(temp.right);
            }
            res.add(rightValue);
        } 

        return res;
    }
}
