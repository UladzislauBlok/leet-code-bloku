package org.bloku.task._1559;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Detect Cycles in 2D Grid")
@Topics({ARRAY, BFS, DFS, UNION_FIND})
class Solution {

  public boolean containsCycleBFS(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j]) continue;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j, -1, -1});
        while (!queue.isEmpty()) {
          int[] cell = queue.poll();
          for (int[] direction : directions) {
            int x = cell[0] + direction[0];
            int y = cell[1] + direction[1];
            if (x < 0 || x == m || y < 0 || y == n || grid[x][y] != grid[i][j]) continue;
            if (x == cell[2] && y == cell[3]) continue;
            if (visited[x][y]) return true;
            visited[x][y] = true;
            queue.add(new int[] {x, y, cell[0], cell[1]});
          }
        }
      }
    }
    return false;
  }

  public boolean containsCycle(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    UnionFind uf = new UnionFind(m * n + 1);
    int[][] directions = new int[][] {{-1, 0}, {0, -1}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int[] direction : directions) {
          int x = i + direction[0];
          int y = j + direction[1];
          if (x < 0 || x == m || y < 0 || y == n || grid[x][y] != grid[i][j]) continue;
          if (uf.find(i * n + j) == uf.find(x * n + y)) return true;
          uf.union(i * n + j, x * n + y);
        }
      }
    }
    return false;
  }

  private final class UnionFind {
    private final int[] parent;

    UnionFind(int n) {
      this.parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    int find(int i) {
      if (parent[i] == i) return i;
      return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
      int pi = find(i);
      int pj = find(j);
      parent[pi] = parent[pj];
    }
  }
}
