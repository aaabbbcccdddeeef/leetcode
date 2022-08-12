import java.util.ArrayList;
import java.util.List;

public class p1282 {
    static public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes == null || groupSizes.length == 0)
            return null;
        int n = groupSizes.length;
        List<List<Integer>> group = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            group.add(new ArrayList<>());
        for (int i = 0; i < n; ++i)
            group.get(groupSizes[i]).add(i);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            int size = group.get(i).size();
            if (size != 0) {
                for (int j = 0; j < size; j += i)
                    ans.add(group.get(i).subList(j, j + i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] tc1 = { 3, 3, 3, 3, 3, 1, 3 };
        groupThePeople(tc1);
    }
}
