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
    boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
        return valid;
    }

    public void dfs(TreeNode node,int max,int min){
        if(node==null)
            return;

        if(valid==false)
            return;


        if(node.val<max && node.val > min){
            dfs(node.left,node.val,min);
            dfs(node.right,max,node.val);
        }else{
            valid = false;
            return;
        }
    }
}
