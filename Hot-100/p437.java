public class p437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = wuHuQiFeng_goooooo(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    private int wuHuQiFeng_goooooo(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (targetSum == root.val) {
            count++;
        }
        count += wuHuQiFeng_goooooo(root.left, targetSum - root.val);
        count += wuHuQiFeng_goooooo(root.right, targetSum - root.val);
        return count;
    }
}
