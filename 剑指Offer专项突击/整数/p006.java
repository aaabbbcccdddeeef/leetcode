public class p006 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[] { 0, n - 1 };
        while (ans[0] < ans[1]) {
            int sum = numbers[ans[0]] + numbers[ans[1]];
            if (sum > target)
                --ans[1];
            else if (sum < target)
                ++ans[0];
            else
                return ans;
        }
        return ans;
    }
}
