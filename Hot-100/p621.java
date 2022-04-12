public class p621 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int len = tasks.length;
            int[] count = new int[26];
            for (char task : tasks) {
                count[task - 'A']++;
            }
            int maxExec = 0;
            for (int i = 0; i < 26; i++) {
                maxExec = Math.max(maxExec, count[i]);
            }
            int maxCount = 0;
            for (int i = 0; i < 26; i++) {
                if (maxExec == count[i]) {
                    maxCount++;
                }
            }
            return Math.max(len, (maxExec - 1) * (n + 1) + maxCount);
        }
    }
}
