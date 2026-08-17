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
    boolean balanceFlag = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanceFlag;
    }


    public int height(TreeNode node){
        if(node==null || balanceFlag == false){
            return 0;
        } 

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        if(Math.abs(lHeight-rHeight)>=2){
            balanceFlag = false;
        }

        return 1+Math.max(lHeight,rHeight);
    }
}
