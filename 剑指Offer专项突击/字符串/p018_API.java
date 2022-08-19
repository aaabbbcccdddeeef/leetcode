public class p018_API {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (char ch : s.toCharArray())
            sb.append(Character.isLetterOrDigit(ch) ? Character.toLowerCase(ch) : "");
        return sb.toString().equals(sb.reverse().toString());
    }
}
