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
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }

        int rightHeight = dfs(node.right);
        int leftHeight = dfs(node.left);

        return 1+Math.max(rightHeight,leftHeight);
    }
}
