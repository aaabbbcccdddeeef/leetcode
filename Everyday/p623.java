public class p623 {
    static public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            addOneRow(root.left, val, depth - 1);
            addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(1);
        // root.right.left = new TreeNode(5);
        addOneRow(root, 5, 4);
    }
}
