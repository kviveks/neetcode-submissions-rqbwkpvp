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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return result;    
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int heightRight = height(root.right);
        int heightLeft = height(root.left);
        result = Math.max(heightRight+heightLeft,result);
        return 1+ Math.max(heightLeft,heightRight);
    }
}
