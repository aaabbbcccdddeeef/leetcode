public class p005 {
    public int maxProduct(String[] words) {
        if (words == null)
            return 0;
        int n = words.length;
        int[] wordMasks = new int[n];
        // call another function decrease speed a lot.
        // for (int i = 0; i < n; ++i)
        //     wordMasks[i] = calculateStringMask(words[i]);
        for (int i = 0; i < n; ++i) {
            int mask = 0;
            for (char ch : words[i].toCharArray())
                mask |= (1 << (ch - 'a'));
            wordMasks[i] = mask;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((wordMasks[i] & wordMasks[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    // // O(l), l is word length
    // public int calculateStringMask(String word) {
    //     if (word == null)
    //         return 0;
    //     // return a integer whose i bit(from right) is 1 if word contains 'a'+i
    //     int n = word.length(), ans = 0;
    //     for (int i = 0; i < n; ++i)
    //         ans = ans | (1 << (word.charAt(i) - 'a'));
    //     return ans;
    // }
}
