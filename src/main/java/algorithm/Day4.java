package algorithm;

import algorithm.quadtree.Node;

/**
 * @author zhuwenxuan
 * @ClassName Day4
 * @date 2022/4/30 0:01
 */
// TODO
// https://leetcode.cn/problems/construct-quad-tree/
public class Day4 {

    // 方法一 递归
//    public Node construct(int[][] grid) {
//        return dfs(grid, 0, grid.length, 0, grid.length);
//    }
//
//    public Node dfs(int[][] grid, int r0, int r1, int c0, int c1) {
//        boolean same = true;
//        for (int i = r0; i < r1; i++) {
//            for (int j = c0; j < c1; j++) {
//                if (grid[i][j] != grid[r0][c0]) {
//                    same = false;
//                    break;
//                }
//            }
//            if (!same) {
//                break;
//            }
//        }
//
//        if (same) {
//            return new Node((grid[r0][c0]) == 1, true);
//        }
//        Node node = new Node(true, false);
//        int rmid = (r0 + r1) / 2;
//        int cmid = (c0 + c1) / 2;
//        node.topLeft = dfs(grid, r0, rmid, c0, cmid);
//        node.topRight = dfs(grid, r0, rmid, cmid, c1);
//        node.bottomLeft = dfs(grid, rmid, r1, c0, cmid);
//        node.bottomRight = dfs(grid, rmid, r1, cmid, c1);
//        return node;
//    }

    // 方法二 前缀和和递归

    public Node construct(int[][] grid) {
        int n = grid.length;
        int[][] pre = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(grid, pre, 0, n, 0, n);
    }

    public Node dfs(int[][] grid, int[][] pre, int r0, int r1, int c0, int c1) {
        int total = getSum(pre, r0, r1, c0, c1);
        if (total == 0) {
            return new Node(false, true);
        } else if (total == (r1 - r0) * (c1 - c0)) {
            return new Node(true, true);
        }
        Node node = new Node(true, false);
        int rmid = (r0 + r1) / 2;
        int cmid = (c0 + c1) / 2;
        node.topLeft = dfs(grid, pre, r0, rmid, c0, cmid);
        node.topRight = dfs(grid, pre, r0, rmid, cmid, c1);
        node.bottomLeft = dfs(grid, pre, rmid, r1, c0, cmid);
        node.bottomRight = dfs(grid, pre, rmid, r1, cmid, c1);
        return node;
    }

    public int getSum(int[][] pre, int r0, int r1, int c0, int c1) {
        return pre[r1][c1] - pre[r1][c0] - pre[r0][c1] + pre[r0][c0];
    }
}
