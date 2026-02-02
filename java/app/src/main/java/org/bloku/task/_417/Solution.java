package org.bloku.task._417;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Pacific Atlantic Water Flow")
@Topics({DFS, BFS})
class Solution {

  private int m, n;
  private int[][] heights;
  private int[] directions = {-1, 0, 1, 0, -1};

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    this.n = heights.length;
    this.m = heights[0].length;
    this.heights = heights;
    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];
    for (int i = 0; i < n; i++) dfs(i, 0, pacific);
    for (int i = 0; i < m; i++) dfs(0, i, pacific);
    for (int i = 0; i < n; i++) dfs(i, m - 1, atlantic);
    for (int i = 0; i < m; i++) dfs(n - 1, i, atlantic);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(Arrays.asList(i, j));
        }
      }
    }
    return result;
  }

  private void dfs(int i, int j, boolean[][] visited) {
    if (visited[i][j]) return;
    visited[i][j] = true;
    for (int k = 0; k < 4; k++) {
      int a = i + directions[k], b = j + directions[k + 1];
      if (a < 0 || b < 0 || a == n || b == m) continue;
      if (heights[a][b] < heights[i][j]) continue;
      dfs(a, b, visited);
    }
  }

  private boolean[][][] paths; // 0 - pacific; 1 - atlantic

  public List<List<Integer>> pacificAtlanticBfs(int[][] heights) {
    int n = heights.length, m = heights[0].length;
    paths = new boolean[n][m][2];
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      queue.offer(new int[] {i, 0});
      queue.offer(new int[] {i, m - 1});
      paths[i][0][0] = true;
      paths[i][m - 1][1] = true;
    }
    for (int i = 0; i < m; i++) {
      queue.offer(new int[] {0, i});
      queue.offer(new int[] {n - 1, i});
      paths[0][i][0] = true;
      paths[n - 1][i][1] = true;
    }
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int a = curr[0], b = curr[1];
      int height = heights[a][b];
      for (int i = 0; i < 4; i++) {
        int a1 = a + directions[i];
        int b1 = b + directions[i + 1];
        if (a1 < 0 || b1 < 0 || a1 == n || b1 == m) continue;
        if (height <= heights[a1][b1]
            && ((paths[a][b][0] && !paths[a1][b1][0]) || (paths[a][b][1] && !paths[a1][b1][1]))) {
          paths[a1][b1][0] |= paths[a][b][0];
          paths[a1][b1][1] |= paths[a][b][1];
          queue.offer(new int[] {a1, b1});
        }
      }
    }
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (paths[i][j][0] && paths[i][j][1]) res.add(List.of(i, j));
      }
    }
    return res;
  }
}
