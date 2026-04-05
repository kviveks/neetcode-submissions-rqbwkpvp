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
    int[] po;
    int[] io;
    int c;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po=preorder;
        io=inorder;
        c = 0;
        return dfs(0,po.length-1);    
    }

    public TreeNode dfs(int l,int r){
        if(l>r){
            return null;
        }
        int num = po[c++];
        TreeNode root = new TreeNode(num);
        int m = searchIndex(num);
        root.left = dfs(l,m-1);
        root.right = dfs(m+1,r);

        return root;
    }

    public int searchIndex(int target){
        for(int i = 0; i<io.length;i++){
            if(io[i]==target){
                return i;
            }
        }
        return 0;
    }
}
