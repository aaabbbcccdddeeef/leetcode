import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderedStream {
    int ptr, capacity;
    Map<Integer, String> map;

    public OrderedStream(int n) {
        ptr = 1;
        map = new HashMap<>();
        capacity = n;
    }

    public List<String> insert(int idKey, String value) {
        map.put(idKey, value);
        List<String> ans = new ArrayList<>();
        while (map.containsKey(ptr))
            ans.add(map.get(ptr++));
        return ans;
    }
}
