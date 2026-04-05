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
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return res;
    }

    public void dfs(TreeNode node, int max){
        if(node==null){
            return;
        }

        if(node.val>=max){
            res = res+1;
        }

        dfs(node.left,Math.max(max,node.val));
        dfs(node.right,Math.max(max,node.val));
    }
}
