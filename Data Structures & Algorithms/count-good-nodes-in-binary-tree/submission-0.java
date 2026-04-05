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
    public int goodNodes(TreeNode root) {
        int maxValue = root.val;
        return countGoodNodes(root,maxValue);       
    }

    // public int countNode(TreeNode root, int maxValue){
    //     if(root==null){
    //         return 0;
    //     }
    //     int add = root.val>maxValue?1:0;
    //     maxValue = Math.max(maxValue,root.val);
    //     return add+countNode(root.left,maxValue)+countNode(root.right,maxValue);
    // }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int good = (node.val >= maxSoFar) ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, node.val);

        return good 
             + countGoodNodes(node.left, maxSoFar) 
             + countGoodNodes(node.right, maxSoFar);
    }
}
