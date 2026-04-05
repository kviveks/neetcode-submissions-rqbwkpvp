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
        pathSum(root);
        return res;    
    }

    public int pathSum(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftHeight = pathSum(node.left);
        int rightHeight = pathSum(node.right);

        res = Math.max(res,node.val+Math.max(leftHeight,0)+Math.max(rightHeight,0));
        return node.val + Math.max(leftHeight,rightHeight);
    }
}
