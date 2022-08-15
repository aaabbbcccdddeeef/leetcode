public class NumMatrix {
    // (0,0) to Pos's area
    int[][] area;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        area = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                area[i + 1][j + 1] = area[i][j + 1] + area[i + 1][j] - area[i][j] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return area[row2 + 1][col2 + 1] - area[row1][col2 + 1] - area[row2 + 1][col1] + area[row1][col1];
    }
}