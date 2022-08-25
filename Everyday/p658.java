import java.util.ArrayList;
import java.util.List;

public class p658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        if (n < k)
            return ans;
        int right = binSearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0)
                ++right;
            else if (right >= n || x - arr[left] <= arr[right] - x)
                --left;
            else
                ++right;
        }
        ++left;
        while (left < right) {
            ans.add(arr[left++]);
        }
        return ans;
    }

    int binSearch(int[] arr, int x) {
        int left = 0, right = arr.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
