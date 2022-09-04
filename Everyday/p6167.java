class p6167 {
    public boolean checkDistances(String s, int[] distance) {
        boolean[] visited = new boolean[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (visited[c - 'a'])
                continue;
            else
                visited[c - 'a'] = true;

            int dis = distance[c - 'a'] + i + 1;
            if (dis >= n || s.charAt(dis) != c)
                return false;
        }
        return true;
    }
}