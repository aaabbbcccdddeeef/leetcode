import java.util.HashMap;
import java.util.Map;

public class p014 {
    static public boolean checkInclusion(String s1, String s2) {
        int lenS1 = s1.length(), lenS2 = s2.length();
        if (lenS1 > lenS2)
            return false;
        // count each charactor's appear times in s1
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int[] cntS1 = new int[26];
        int[] cntS2 = new int[26];
        for (char ch : s1Arr)
            ++cntS1[ch - 'a'];
        int start = 0, end = 0;
        while (start + lenS1 <= lenS2 && end - start != lenS1) {
            char ch = s2Arr[end++];
            ++cntS2[ch - 'a'];
            while (cntS1[ch - 'a'] < cntS2[ch - 'a']) {
                char tmp = s2Arr[start++];
                --cntS2[tmp - 'a'];
            }
        }
        return start + lenS1 == end ? true : false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        checkInclusion(s1, s2);
    }
}