public class p1374 {
    public String generateTheString(int n) {
        if ((n & 1) != 0) {
            return "f".repeat(n);
        } else {
            return "f".repeat(n - 1) + "k";
        }
    }
}