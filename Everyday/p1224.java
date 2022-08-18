public class p1224 {
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[100010];
        int[] freq = new int[100010];
        int ans = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i], currCnt = ++cnt[num], len = i + 1;
            ++freq[currCnt];
            --freq[currCnt - 1];
            maxFreq = Math.max(maxFreq, currCnt);
            if (maxFreq == 1)
                ans = len;
            if (freq[maxFreq] == 1 && freq[maxFreq - 1] * (maxFreq - 1) + maxFreq == len)
                ans = len;
            if (freq[1] == 1 && freq[maxFreq] * maxFreq + 1 == len)
                ans = len;
        }
        return ans;
    }
}