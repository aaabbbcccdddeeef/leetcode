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
        int lastTime = 0; // abs value: last log's time. positive: last log is 'start'. negative: last log
                          // is 'end'
        for (String log : logs) {
            int id = getID(log), time = getTime(log);
            if (log.indexOf("start") >= 0) {
                // this is a call of this function
                if (!idStk.isEmpty())
                    ans[idStk.peek()] += lastTime >= 0 ? time - lastTime : time + lastTime - 1;
                idStk.push(id);
                lastTime = time;
            } else {
                // this is end of this function. Calculate the time
                if (idStk.isEmpty() || idStk.peek() != id) {
                    System.out.println("Wrong Func ID: " + id);
                    break;
                }
                ans[idStk.pop()] += lastTime >= 0 ? time - lastTime + 1 : time + lastTime;
                lastTime = -time;
            }
        }
        return ans;
    }

    static public int getID(String log) {
        int idx = log.contains(":start") ? log.indexOf(":start") : log.indexOf(":end");
        return Integer.parseInt(log.substring(0, idx));
    }

    static public int getTime(String log) {
        int idx = log.contains(":start:") ? log.indexOf(":start:") + 7 : log.indexOf(":end:") + 5;
        return Integer.parseInt(log.substring(idx));
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(new String[] { "0:start:0", "1:start:2", "1:end:5", "0:end:6" });
        System.out.println(Arrays.toString(exclusiveTime(2, logs)));
        logs = Arrays.asList(new String[] { "0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7" });
        System.out.println(Arrays.toString(exclusiveTime(1, logs)));
    }
}