public class p124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left), right = getSum(root.right);
        int leftSum = left + root.val;
        int midSum = left + root.val + right;
        int rightSum = right + root.val;
        maxSum = Math.max(Math.max(maxSum, leftSum), Math.max(midSum, rightSum));
        maxSum = Math.max(maxSum, root.val);
        return Math.max(leftSum, Math.max(rightSum, root.val));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
