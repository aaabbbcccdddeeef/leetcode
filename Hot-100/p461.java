public class p461 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y, count = 0;
        while (num != 0) {
            count++;
            num &= num - 1;
        }
        return count;
    }
}
