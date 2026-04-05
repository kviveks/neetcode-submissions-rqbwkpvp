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

        int leftHeight = Math.max(pathSum(node.left),0);
        int rightHeight = Math.max(pathSum(node.right),0);

        res = Math.max(res,node.val+leftHeight+rightHeight);
        return node.val + Math.max(leftHeight,rightHeight);
    }
}
