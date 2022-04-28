public class p169 {
    public int majorityElement(int[] nums) {
        int maj = nums[0], vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maj) {
                vote++;
            } else {
                if (--vote < 0) {
                    maj = nums[i];
                    vote = 1;
                }
            }
        }
        return maj;
    }
}
