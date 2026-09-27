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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }

    public int height(TreeNode node){
        if(node==null || flag==false) return 0;

        int heightL = height(node.left);
        int heightR = height(node.right);
        if(Math.abs(heightL-heightR)>1){
            flag=false;
        }
        return 1+Math.max(heightL,heightR);
    }
}
