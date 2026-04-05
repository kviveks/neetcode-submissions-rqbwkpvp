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
        if(res==false){
            return 0;
        }

        if(node==null){
            return 0;
        }

        int rightHeight = height(node.right);
        int leftHeight = height(node.left);

        if(Math.abs(leftHeight-rightHeight)>1){
            res = false;
        }

        return 1+Math.max(leftHeight,rightHeight);
    }
}
