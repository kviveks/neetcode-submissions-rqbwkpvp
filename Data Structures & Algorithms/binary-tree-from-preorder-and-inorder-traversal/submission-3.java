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
    int c = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return dfs(preorder,inorder,0,preorder.length-1); 
    }

    public TreeNode dfs(int[] preorder, int[] inorder,int l,int r){
        if(l>r){
            return null;
        }
        int num = preorder[c++];
        TreeNode node = new TreeNode(num);
        int m = searchIndex(num,inorder);
        node.left=dfs(preorder,inorder,l,m-1);
        node.right=dfs(preorder,inorder,m+1,r);

        return node;

    }

    public int searchIndex(int target,int[] inorder){
        for(int i = 0; i<inorder.length;i++){
            if(inorder[i]==target){
                return i;
            }
        }
        return 0;
    }
}
