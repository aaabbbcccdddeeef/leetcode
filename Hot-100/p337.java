import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class p337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        // root.left.left=new TreeNode(1);
        root.left.right = new TreeNode(4);
        // root.right.right=new TreeNode(1);
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int selected = root.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] { selected, notSelected };
    }
}