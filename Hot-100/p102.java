import java.util.*;

public class p102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = 1, nextN = 0;
        while (!queue.isEmpty()) {
            List<Integer> line = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    continue;
                }
                nextN += 2;
                line.add(tmp.val);
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
            if (!line.isEmpty()) {
                ans.add(line);
            }
            n = nextN;
            nextN = 0;
        }
        return ans;
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
