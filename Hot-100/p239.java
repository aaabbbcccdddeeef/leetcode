import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class p239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.valueOf(nums[o2]).compareTo(Integer.valueOf(nums[o1]));
            }
        });
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        boolean[] enabled = new boolean[n - k + 1];
        for (int i = 0; i < k; i++) {
            q.offer(i);
            enabled[i] = true;
        }
        ans[0] = nums[q.peek()];
        for (int i = 1; i < n - k + 1; i++) {
            enabled[i - 1] = false;
            enabled[i + k - 1] = true;
            q.offer(i + k - 1);
            while (!enabled[q.peek()]) {
                q.poll();
            }
            ans[i] = nums[q.peek()];
        }
        return ans;
    }
}