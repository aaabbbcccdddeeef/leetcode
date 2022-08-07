import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class p636 {
    static public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || n == 0)
            return null;
        int[] ans = new int[n];
        Deque<Integer> idStk = new ArrayDeque<>();
        int lastEndTime = 0;
        for (String log : logs) {
            String[] info = log.split(":");
            int id = Integer.parseInt(info[0]), time = Integer.parseInt(info[2]);
            if (info[1].equals("start")) {
                if (!idStk.isEmpty())
                    ans[idStk.peek()] += time - lastEndTime;
                idStk.push(id);
                lastEndTime = time;
            } else {
                ans[idStk.pop()] += time - lastEndTime + 1;
                lastEndTime = time + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(new String[] { "0:start:0", "1:start:2", "1:end:5", "0:end:6" });
        System.out.println(Arrays.toString(exclusiveTime(2, logs)));
        logs = Arrays.asList(new String[] { "0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7" });
        System.out.println(Arrays.toString(exclusiveTime(1, logs)));
    }
}