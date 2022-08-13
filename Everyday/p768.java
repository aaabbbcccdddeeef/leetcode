import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p768 {
    static public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(sorted[i], map.getOrDefault(sorted[i], i));
        }
        int ans = 0;
        for (int i = 0; i < n;) {
            int rightLim = map.get(arr[i]);
            map.put(arr[i], map.get(arr[i++]) + 1);
            while (i <= rightLim) {
                rightLim = Math.max(rightLim, map.get(arr[i]));
                map.put(arr[i], map.get(arr[i++]) + 1);
            }
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 2, 2, 1, 1 };
        maxChunksToSorted(arr);
    }
}
