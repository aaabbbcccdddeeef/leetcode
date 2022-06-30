public class p42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] <= height[right]) {
                left++;
                if (height[left] < Math.min(leftMax, rightMax)) {
                    ans += Math.min(leftMax, rightMax) - height[left];
                }
            } else {
                right--;
                if (height[right] < Math.min(leftMax, rightMax)) {
                    ans += Math.min(leftMax, rightMax) - height[right];
                }
            }
        }
        return ans;
    }
}
