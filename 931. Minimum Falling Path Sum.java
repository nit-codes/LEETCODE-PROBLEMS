class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] t = new int[m][m];

        // initialization
        for (int col = 0; col < m; col++) {
            t[0][col] = matrix[0][col];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < m; col++) {
                t[row][col] = matrix[row][col] + Math.min(
                        t[row - 1][col],
                        Math.min(t[row - 1][Math.max(0, col - 1)], t[row - 1][Math.min(m - 1, col + 1)])
                );
            }
        }

        return Arrays.stream(t[m - 1]).min().orElse(0);
    }
}
