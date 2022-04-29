package algorithm;

/**
 * @author zhuwenxuan
 * @date 2022/4/26 23:45
 */
public class Day1 {
    public static void main(String[] args) {

    }

    public int ProjectionArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int max1 = 0;
            int max2 = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    ans++;
                if (grid[i][j] > max1)
                    max1 = grid[i][j];
                if (grid[j][i] > max2)
                    max2 = grid[j][i];
            }
            ans += (max1 + max2);
        }
        return ans;
    }
}
