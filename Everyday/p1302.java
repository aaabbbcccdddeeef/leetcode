import java.util.LinkedList;
import java.util.Queue;

public class p1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
        }
        return sum;
    }
}