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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        heightSum(root);
        return res;
    }

    public int heightSum(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftHeight = Math.max(heightSum(node.left),0);
        int rightHeight = Math.max(heightSum(node.right),0);

        res=Math.max(res,leftHeight+rightHeight+node.val);

        return node.val + Math.max(leftHeight,rightHeight);
    }
}
