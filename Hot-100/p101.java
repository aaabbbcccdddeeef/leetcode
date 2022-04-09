public class p101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTwo(root.left, root.right);
    }

    public boolean isSymmetricTwo(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSymmetricTwo(left.left, right.right) && isSymmetricTwo(left.right, right.left);
        }
        return false;
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
