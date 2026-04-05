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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        return levelOrder1(root);
    }

    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Deque<TreeNode> pq = new ArrayDeque<>();

        pq.addLast(root);
        int count = 0;
        
        while(!pq.isEmpty()){
            int size = pq.size();
            res.add(new ArrayList<Integer>());
            for(int i=1;i<=size;i++){
                TreeNode temp = pq.removeFirst();
                res.get(count).add(temp.val);
                if(temp.left!=null)
                    pq.add(temp.left);

                if(temp.right!=null)
                    pq.add(temp.right);
            }
            count++;
        }

        return res;
    }
}
