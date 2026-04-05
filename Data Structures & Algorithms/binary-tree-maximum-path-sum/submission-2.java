class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Calculate the maximum path sum for left and right subtrees, ignoring negative sums
        int leftWingSum = Math.max(dfs(root.left), 0);  // Ignore negative paths
        int rightWingSum = Math.max(dfs(root.right), 0); // Ignore negative paths

        // Calculate the maximum path sum including the current node
        int currentMax = root.val + Math.max(leftWingSum, rightWingSum);

        // Update the global maximum path sum considering the case where the path goes through the root
        max = Math.max(max, root.val + leftWingSum + rightWingSum);

        // Return the maximum sum path starting from the current node
        return currentMax;
    }


}





























