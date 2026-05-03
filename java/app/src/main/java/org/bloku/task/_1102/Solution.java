package org.bloku.task._1102;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Path With Maximum Minimum Value")
@Topics({ARRAY, BINARY_SEARCH, DFS, BFS, UNION_FIND, HEAP_PRIORITY_QUEUE})
class Solution {

  public int maximumMinimumPath(int[][] grid) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
    int m = grid.length, n = grid[0].length;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited = new boolean[m][n];
    pq.add(new int[] {0, 0, grid[0][0]});
    int min = Integer.MAX_VALUE;
    while (!pq.isEmpty()) {
      int[] cell = pq.poll();
      int i = cell[0], j = cell[1], score = cell[2];
      min = Math.min(min, score);
      if (i == m - 1 && j == n - 1) break;
      visited[i][j] = true;
      for (int[] dir : directions) {
        int x = i + dir[0];
        int y = j + dir[1];
        if (x < 0 || x == m || y < 0 || y == n || visited[x][y]) continue;
        pq.add(new int[] {x, y, grid[x][y]});
      }
    }
    return min;
  }

  public int maximumMinimumPathBS(int[][] grid) {
    Set<Integer> set = new HashSet<>();
    for (int[] row : grid) {
      for (int cell : row) {
        set.add(cell);
      }
    }
    int m = grid.length, n = grid[0].length;
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    int low = 0, high = list.size() - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (dfs(0, 0, new boolean[m][n], list.get(mid), grid)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return list.get(low - 1);
  }

  private boolean dfs(int i, int j, boolean[][] visited, int min, int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (i < 0 || i == m || j < 0 || j == n || visited[i][j] || grid[i][j] < min) return false;
    if (i == m - 1 && j == n - 1) return true;
    visited[i][j] = true;
    return dfs(i + 1, j, visited, min, grid)
        || dfs(i - 1, j, visited, min, grid)
        || dfs(i, j + 1, visited, min, grid)
        || dfs(i, j - 1, visited, min, grid);
  }
}
