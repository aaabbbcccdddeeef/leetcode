public class p1413 {
    public int minStartValue(int[] nums) {
        int accumulateSum = 0, minSum = 0;
        for (var x : nums) {
            accumulateSum += x;
            minSum = Math.min(minSum, accumulateSum);
        }
        return minSum >= 0 ? 1 : 1 - minSum;
    }
}