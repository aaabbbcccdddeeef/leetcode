import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        DisjointSet ds = new DisjointSet(size * 2);
        Map<String, Integer> hashMap = new HashMap<>(2 * size);
        int id = 0;
        for (int i = 0; i < size; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!hashMap.containsKey(a)) {
                hashMap.put(a, id++);
            }
            if (!hashMap.containsKey(b)) {
                hashMap.put(b, id++);
            }
            ds.set_union(hashMap.get(a), hashMap.get(b), values[i]);
        }
        int queriesSize = queries.size();
        double[] ans = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            Integer id1 = hashMap.get(queries.get(i).get(0));
            Integer id2 = hashMap.get(queries.get(i).get(1));
            if (id1 == null || id2 == null || ds.find(id1) != ds.find(id2)) {
                ans[i] = -1.0d;
            } else {
                ans[i] = ds.getRate(id1, id2);
            }
        }
        return ans;
    }

    private class DisjointSet {
        private int[] parent;
        private double[] weight;

        public DisjointSet(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void set_union(int a, int b, double value) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot != bRoot) {
                parent[aRoot] = bRoot;
                weight[aRoot] = weight[b] * value / weight[a];
            }
        }

        public int find(int a) {
            if (a != parent[a]) {
                int origin = parent[a];
                parent[a] = find(parent[a]);
                weight[a] *= weight[origin];
            }
            return parent[a];
        }

        public double getRate(int a, int b) {
            return weight[a] / weight[b];
        }
    }
}