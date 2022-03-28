import java.util.*;

public class p78 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    void backtrack(int[] nums, int k) {
        if (k == nums.length) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[k]);
        backtrack(nums, k+1);
        temp.remove(temp.size()-1);
        backtrack(nums, k+1);
    }
}
