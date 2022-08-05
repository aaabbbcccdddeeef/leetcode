public class p623 {
    static public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode dummyRoot = new TreeNode(0, root, null);
        dfsAndAdd(dummyRoot, val, depth, 0);
        return dummyRoot.left;
    }

    static public void dfsAndAdd(TreeNode root, int val, int depth, int currDepth) {
        if (root == null)
            return;
        if (currDepth + 1 == depth) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            dfsAndAdd(root.left, val, depth, currDepth + 1);
            dfsAndAdd(root.right, val, depth, currDepth + 1);
        }
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
