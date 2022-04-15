import java.util.*;

public class p438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }
        int[] count = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a'] += 1;
            pCount[p.charAt(i) - 'a'] += 1;
        }
        int need = 0;
        for (int i = 0; i < 26; i++) {
            need += count[i] < pCount[i] ? pCount[i] - count[i] : 0;
        }
        List<Integer> ans = new ArrayList<Integer>();
        if (need == 0) {
            ans.add(0);
        }
        for (int i = 1; i + pLen <= sLen; i++) {
            if (count[s.charAt(i - 1) - 'a'] <= pCount[s.charAt(i - 1) - 'a']) {
                need++;
            }
            count[s.charAt(i - 1) - 'a']--;
            if (count[s.charAt(i + pLen - 1) - 'a'] < pCount[s.charAt(i + pLen - 1) - 'a']) {
                need--;
            }
            count[s.charAt(i + pLen - 1) - 'a']++;
            if (need == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
