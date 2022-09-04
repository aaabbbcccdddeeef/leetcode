import java.util.Arrays;

public class p6170 {
    static public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];
        long[] endTime = new long[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < meetings.length; ++i) {
            int minEndTimeIdx = 0;
            for (int j = 1; j < n; ++j) {
                if (endTime[minEndTimeIdx] > meetings[i][0] && endTime[minEndTimeIdx] > endTime[j])
                    minEndTimeIdx = j;
                if (endTime[minEndTimeIdx] <= meetings[i][0] || endTime[minEndTimeIdx] == 0)
                    break;
            }
            ++cnt[minEndTimeIdx];
            long lastEndTime = endTime[minEndTimeIdx];
            if (lastEndTime > meetings[i][0]) {
                endTime[minEndTimeIdx] = meetings[i][1] + lastEndTime - meetings[i][0];
            } else {
                endTime[minEndTimeIdx] = meetings[i][1];
            }
        }
        int res = 0;
        for (int i = 1; i < n; ++i) {
            if (cnt[i] > cnt[res])
                res = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] meetings = { { 18, 19 }, { 3, 12 }, { 17, 19 }, { 2, 13 }, { 7, 10 } };
        System.out.println(mostBooked(4, meetings));
    }
}
