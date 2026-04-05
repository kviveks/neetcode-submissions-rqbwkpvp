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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,root.val);
        return count;
    }

    public void dfs(TreeNode node,int maxValue){
        if(node==null)
            return;

        if(node.val>=maxValue){
            count++;
        }

        dfs(node.left,Math.max(maxValue,node.val));
        dfs(node.right,Math.max(maxValue,node.val));
    }
}
