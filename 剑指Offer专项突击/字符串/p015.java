import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p015 {
    static public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> ans = new ArrayList<>();
        int lenS1 = s1.length(), lenS2 = s2.length();
        if (lenS1 > lenS2)
            return ans;
        // count each charactor's appear times in s1, s2
        char[] s1Arr = s1.toCharArray(), s2Arr = s2.toCharArray();
        int[] cntS1 = new int[26], cntS2 = new int[26];
        for (int i = 0; i < lenS1; ++i) {
            ++cntS1[s1Arr[i] - 'a'];
            ++cntS2[s2Arr[i] - 'a'];
        }
        if (Arrays.equals(cntS1, cntS2))
            ans.add(0);
        for(int i=0;i<lenS2-lenS1;++i) {
            --cntS2[s2Arr[i] - 'a'];
            ++cntS2[s2Arr[i+lenS1] - 'a'];
            if (Arrays.equals(cntS1, cntS2))
                ans.add(i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "bacd", s2 = "abc";
        findAnagrams(s1, s2);
    }
}