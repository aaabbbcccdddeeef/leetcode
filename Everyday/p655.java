import java.util.ArrayList;
import java.util.List;

public class p655 {
    int height;

    public List<List<String>> printTree(TreeNode root) {
        height = getHeight(root)-1;
        int m = height + 1, n = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            res.add(new ArrayList<>());
            for (int j = 0; j < n; ++j)
                res.get(i).add("");
        }
        dfsAndFill(root, 0, (n - 1) / 2, res);
        return res;
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    void dfsAndFill(TreeNode root, int row, int col, List<List<String>> res) {
        if (root == null)
            return;
        res.get(row).set(col, String.valueOf(root.val));
        int left = col - (1 << (height - row - 1)), right = col + (1 << (height - row - 1));
        dfsAndFill(root.left, row + 1, left, res);
        dfsAndFill(root.right, row + 1, right, res);
    }
}