public class p002 {
    public String addBinary(String a, String b) {
        if (a == null || b == null)
            return "";
        StringBuilder sb = new StringBuilder();
        int aLen = a.length(), bLen = b.length();
        int n = Math.max(aLen, bLen);
        int carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < aLen ? (a.charAt(aLen - 1 - i) - '0') : 0;
            carry += i < bLen ? (b.charAt(bLen - 1 - i) - '0') : 0;
            // 倒序添加元素
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry != 0)
            sb.append('1');
        return sb.reverse().toString();
    }
}
