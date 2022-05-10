import java.util.HashMap;
import java.util.Map;

public class p105 {
    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return recuBuild(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode recuBuild(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int preorder_root = pl;
        int inorder_root = indexMap.get(preorder[preorder_root]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int leftSize = inorder_root - il;
        root.left = recuBuild(preorder, inorder, pl + 1, pl + leftSize, il, inorder_root - 1);
        root.right = recuBuild(preorder, inorder, pl + leftSize + 1, pr, inorder_root + 1, ir);
        return root;
    }
}
