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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return isValid(root,root.val,root.val);
    }

    public boolean isValid(TreeNode root,int max,int min){

        if(root==null){
            return true;
        }

        if(root.left!=null && root.left.val>=max){
            return false;
        }

        if(root.right!=null && root.right.val<=min){
            return false;
        }

        if(root.right==null && root.left == null)
            return true;

        max = Math.max(max,root.val);
        min = Math.min(min,root.val);

        return isValid(root.left,max,min) && isValid(root.right,max,min);

    }
}
