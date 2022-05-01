import java.util.ArrayList;
import java.util.List;

public class p1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        inorder(root1, lst1);
        inorder(root2, lst2);
        List<Integer> ans = new ArrayList<>();
        int n1 = lst1.size(), n2 = lst2.size();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            if (i < n1 && j < n2) {
                if (lst1.get(i) < lst2.get(j)) {
                    ans.add(lst1.get(i++));
                } else {
                    ans.add(lst2.get(j++));
                }
            } else if (i < n1) {
                ans.add(lst1.get(i++));
            } else {
                ans.add(lst2.get(j++));
            }
        }
        return ans;
    }

    private static void inorder(TreeNode root, List<Integer> lst) {
        if (root == null) {
            return;
        }
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }
}