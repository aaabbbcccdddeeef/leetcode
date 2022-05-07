import java.util.ArrayList;
import java.util.List;

class p236 {
    public static void main(String[] args) {
        p236 p=new p236();
        TreeNode n1=new TreeNode(1);
        n1.left=new TreeNode(2);
        p.lowestCommonAncestor(n1, n1.left, n1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> lst1 = new ArrayList<>();
        List<TreeNode> lst2 = new ArrayList<>();
        dfs(root, lst1, p.val);
        dfs(root, lst2, q.val);
        int n1 = lst1.size(), n2 = lst2.size(), i;
        for (i = 0; i < Math.min(n1, n2); i++) {
            if (lst1.get(i) != lst2.get(i)) {
                return lst1.get(i - 1);
            }
        }
        return i == Math.min(n1, n2) ? lst1.get(i-1) : root;
    }

    private void dfs(TreeNode root, List<TreeNode> lst, int target) {
        if (root == null) {
            return;
        }
        lst.add(root);
        dfs(root.left, lst, target);
        dfs(root.right, lst, target);
        if (lst.get(lst.size() - 1).val == target) {
            return;
        }
        lst.remove(lst.size() - 1);
    }
}