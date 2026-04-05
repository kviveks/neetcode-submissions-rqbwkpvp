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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }

        int rightHeight = height(node.right);
        int leftHeight = height(node.left);

        res = Math.max(res,rightHeight+leftHeight);

        return 1+Math.max(rightHeight,leftHeight);
    }
}
