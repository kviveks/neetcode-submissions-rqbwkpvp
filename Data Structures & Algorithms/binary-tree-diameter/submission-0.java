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
        heightOfSide(root);
        return result; 
    }

    public int heightOfSide(TreeNode root){
        if(root==null){
            return 0;
        }

        result = Math.max(heightOfSide(root.left)+heightOfSide(root.right),result);

        return 1+ Math.max(heightOfSide(root.left),heightOfSide(root.right));
    }
}
