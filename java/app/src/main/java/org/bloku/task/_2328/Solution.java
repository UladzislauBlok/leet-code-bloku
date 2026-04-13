package org.bloku.task._2328;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Increasing Paths in a Grid")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, DFS})
class Solution {
  public int countPaths_(int[][] grid) {
    final int mod = (int) 1e9 + 7;
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    Map<Integer, List<int[]>> map = new HashMap<>();
    int max = grid[0][0], min = grid[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int num = grid[i][j];
        max = Math.max(max, num);
        min = Math.min(min, num);
        map.computeIfAbsent(num, __ -> new ArrayList<>()).add(new int[] {i, j});
      }
    }
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int result = 0;
    for (int i = max; i >= min; i--) {
      if (!map.containsKey(i)) continue;
      for (int[] point : map.get(i)) {
        int sum = 1;
        for (int[] direction : directions) {
          int row = point[0] + direction[0];
          int col = point[1] + direction[1];
          if (row < 0 || col < 0 || row == m || col == n) continue;
          if (grid[row][col] > grid[point[0]][point[1]]) {
            sum = (sum + dp[row][col]) % mod;
          }
        }
        dp[point[0]][point[1]] = sum;
        result = (result + sum) % mod;
      }
    }
    return result;
  }

  private final int MOD = (int) 1e9 + 7;
  private final int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  private int m, n;
  private int[][] grid;
  private int[][] dp;

  public int countPaths(int[][] grid) {
    this.grid = grid;
    m = grid.length;
    n = grid[0].length;
    dp = new int[m][n];
    int ans = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        ans = (ans + dfs(i, j)) % MOD;
      }
    }

    return ans;
  }

  private int dfs(int i, int j) {
    if (dp[i][j] != 0) return dp[i][j];
    int sum = 1;
    for (int[] direction : directions) {
      int row = i + direction[0];
      int col = j + direction[1];
      if (row < 0 || col < 0 || row == m || col == n) continue;
      if (grid[row][col] > grid[i][j]) {
        sum = (sum + dfs(row, col)) % MOD;
      }
    }
    dp[i][j] = sum;
    return dp[i][j];
  }
}
