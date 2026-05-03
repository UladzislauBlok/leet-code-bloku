package org.bloku.task._1391;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Check if There is a Valid Path in a Grid")
@Topics({ARRAY, DFS, BFS, UNION_FIND})
class Solution {

  public boolean hasValidPath(int[][] grid) {
    int[][] map =
        new int[][] {
          {},
          {0, -1, 0, 1},
          {-1, 0, 1, 0},
          {1, 0, 0, -1},
          {1, 0, 0, 1},
          {-1, 0, 0, -1},
          {-1, 0, 0, 1}
        };
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int[] prev = map[grid[0][0]];
    return dfs(0, 0, prev[0], prev[1], visited, map, grid);
  }

  private boolean dfs(
      int i, int j, int pi, int pj, boolean[][] visited, int[][] map, int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (i < 0 || i == m || j < 0 || j == n || visited[i][j]) return false;
    int[] direction = map[grid[i][j]];
    if ((i + direction[0] != pi || j + direction[1] != pj)
        && (i + direction[2] != pi || j + direction[3] != pj)) return false;
    if (i == m - 1 && j == n - 1) return true;
    visited[i][j] = true;
    return dfs(i + direction[0], j + direction[1], i, j, visited, map, grid)
        || dfs(i + direction[2], j + direction[3], i, j, visited, map, grid);
  }
}
