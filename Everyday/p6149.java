import java.util.HashMap;
import java.util.Map;

public class p6149 {
    static public int edgeScore(int[] edges) {
        // continue adding may go over bound of int, so use long
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            map.put(edges[i], map.getOrDefault(edges[i], 0l) + i);
        }
        long count = 0, n = 0;
        for (var x : map.keySet()) {
            if (map.get(x) >= count) {
                if (map.get(x) == count)
                    n = Math.min(n, x);
                else
                    n = x;
                count = map.get(x);
            }
        }
        return (int) n;
    }

    public static void main(String[] args) {
        int[] edges = new int[] { 1, 0, 0, 0, 0, 7, 7, 5 };
        edgeScore(edges);
    }
}
