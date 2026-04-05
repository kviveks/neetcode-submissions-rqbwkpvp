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
    public TreeNode invertTree(TreeNode root) {
        preOrder(root);
        return root; 
    }

    public void preOrder(TreeNode node){
        if(node==null)
            return;
        TreeNode right = node.right;
        TreeNode left = node.left;

        node.right = left;
        node.left = right;

        preOrder(node.right);
        preOrder(node.left);
    }
}
