import java.util.*;

public class p406 {
    public int[][] reconstructQueue(int[][] people) {
        int num = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] t1, int[] t2) {
                return t1[0] == t2[0] ? t2[1] - t1[1] : t1[0] - t2[0];
            }
        });
        int[][] ans = new int[num][];
        for (int[] person : people) {
            int space = person[1] + 1;
            for (int i = 0; i < num; i++) {
                if (ans[i] == null) {
                    space--;
                }
                if (space == 0) {
                    ans[i] = person;
                    break;
                }
            }
        }
        return ans;
    }
}
