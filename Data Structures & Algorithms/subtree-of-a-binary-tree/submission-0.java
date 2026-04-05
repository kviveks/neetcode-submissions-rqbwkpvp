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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) return false;

        if(isSame(root,subRoot)){
            return true;
        }
        
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    public boolean isSame(TreeNode p,TreeNode q){
        if(p==null&&q==null)
            return true;

        if(p!=null&&q==null)
            return false;
        
        if(p==null&&q!=null)
            return false;

        return p.val==q.val && isSame(p.right,q.right) && isSame(p.left,q.left);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null && q!=null){
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        return p.val==q.val && isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
    }

}
