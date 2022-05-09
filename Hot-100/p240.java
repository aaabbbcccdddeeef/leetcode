public class p240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && m >= 0) {
            int val = matrix[i][j];
            if (val == target) {
                return true;
            }
            if (val > target) {
                j--;
            }
            if (val < target) {
                i++;
            }
        }
        return false;
    }
}