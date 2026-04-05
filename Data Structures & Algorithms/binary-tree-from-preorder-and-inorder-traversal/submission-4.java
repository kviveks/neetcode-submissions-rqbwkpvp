class Solution {

    int preIndex = 0;
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int left, int right){

        if(left > right) return null;

        int val = preorder[preIndex++];
        TreeNode node = new TreeNode(val);

        int index = map.get(val);

        node.left = dfs(preorder, left, index - 1);
        node.right = dfs(preorder, index + 1, right);

        return node;
    }
}