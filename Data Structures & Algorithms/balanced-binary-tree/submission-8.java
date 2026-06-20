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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode node){
        if(node==null) return 0;
        if(res==false) return 0;

        int lheight = height(node.left);
        int rheight = height(node.right);

        if(Math.abs(lheight-rheight)>1) {
            res = false;
        }

        return 1+Math.max(lheight,rheight);
    }
}
