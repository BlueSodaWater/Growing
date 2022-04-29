package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuwenxuan
 * @date 2022/4/27 20:47
 */
public class Day2 {
    public static void main(String[] args) {

    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int m, n;

    // https://leetcode.cn/problems/pacific-atlantic-water-flow/solution/tai-ping-yang-da-xi-yang-shui-liu-wen-ti-sjk3/
    // TODO
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add((i));
                    cell.add((j));
                    ans.add(cell);
                }
            }
        }
        return ans;
    }

    public void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }

        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < this.m && newCol >= 0 && newCol < this.n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }

    }
}
