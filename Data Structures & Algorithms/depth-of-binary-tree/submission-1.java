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

// class Solution {
//     public int maxDepth(TreeNode root) {
//         return maxDepthCount(root,0);    
//     }
    
//     public int maxDepthCount(TreeNode node,int count){
//         if(node == null){
//             return count;
//         }

//         return  Math.max(maxDepthCount(node.left,count+1),maxDepthCount(node.right,count+1));
        
//     }
// }


class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        } 

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
