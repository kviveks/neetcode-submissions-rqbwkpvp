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
        if(node==null){
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        preOrder(node.left);
        preOrder(node.right);
    }
}
