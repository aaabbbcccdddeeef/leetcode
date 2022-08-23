public class p782 {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int row1 = -1, row2 = -1, col1 = -1, col2 = -1, mask = (1 << n) - 1;
        for (int i = 0; i < n; ++i) {
            int rowMask = 0, colMask = 0;
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 1)
                    rowMask += (1 << j);
                if (board[j][i] == 1)
                    colMask += (1 << j);
            }
            if (row1 == -1)
                row1 = rowMask;
            else if (row2 == -1 && rowMask != row1)
                row2 = rowMask;
            if (col1 == -1)
                col1 = colMask;
            else if (col2 == -1 && colMask != col1)
                col2 = colMask;
            if (rowMask != row1 && rowMask != row2)
                return -1;
            if (colMask != col1 && colMask != col2)
                return -1;
        }
        if (Integer.bitCount(row1) + Integer.bitCount(row2) != n)
            return -1;
        if (Integer.bitCount(col1) + Integer.bitCount(col2) != n)
            return -1;
        if ((row1 ^ row2) != mask || (col1 ^ col2) != mask)
            return -1;
        int t = 0;
        for (int i = 0; i < n; i += 2)
            t += (1 << i);
        int ans = Math.min(getCnt(row1, t), getCnt(row2, t)) + Math.min(getCnt(col1, t), getCnt(col2, t));
        return ans >= 0x3f3f3f3f ? -1 : ans;
    }

    int getCnt(int a, int b) {
        return Integer.bitCount(a) != Integer.bitCount(b) ? 0x3f3f3f3f : Integer.bitCount(a ^ b) / 2;
    }
}
