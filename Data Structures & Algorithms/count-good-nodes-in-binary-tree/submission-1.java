class Solution {
    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode root, int maxSoFar) {
        if (root == null) return;

        if (root.val >= maxSoFar) {
            res++;
        }

        int newMax = Math.max(maxSoFar, root.val);

        dfs(root.left, newMax);
        dfs(root.right, newMax);
    }
}
