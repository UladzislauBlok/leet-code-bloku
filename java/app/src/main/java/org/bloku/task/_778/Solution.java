package org.bloku.task._778;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Swim in Rising Water")
@Topics({BFS, DFS, HEAP_PRIORITY_QUEUE, BINARY_SEARCH})
class Solution {

  // It's kind of finding path
  // 1) The find optiomal path we can choose the ceil
  // with min value and explore path in kind of bfs maner
  // n is max 50, so even O(n^2*log n) should do just fine
  // the final result would be the biggest cail along the path
  // 2) For second approach we can try to perform full with checking
  // if we we can achive better results
  // 3) dfs with binary search
  public int swimInWater(int[][] grid) {
    int n = grid.length;
    int left = grid[0][0];
    int right = n * n - 1;
    while (left < right) {
      int mid = (right + left) >> 1;
      boolean[][] visited = new boolean[n][n];
      if (dfs(grid, mid, visited, 0, 0)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean dfs(int[][] grid, int t, boolean[][] visited, int a, int b) {
    int n = grid.length;
    if (a < 0 || b < 0 || a == n || b == n || visited[a][b] || grid[a][b] > t) return false;
    if (a == n - 1 && b == n - 1) return true;
    visited[a][b] = true;
    int[] d = {-1, 0, 1, 0, -1};
    for (int i = 0; i < 4; i++) {
      if (dfs(grid, t, visited, a + d[i], b + d[i + 1])) return true;
    }
    return false;
  }

  public int swimInWaterBfs(int[][] grid) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {0, 0});
    int[] d = new int[] {-1, 0, 1, 0, -1};
    int n = grid.length;
    int[][] paths = new int[n][n];
    for (int[] row : paths) Arrays.fill(row, Integer.MAX_VALUE);
    paths[0][0] = grid[0][0];
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int a = curr[0] + d[i], b = curr[1] + d[i + 1];
        if (a < 0 || b < 0 || a == n || b == n) continue;
        int elev = Math.max(paths[curr[0]][curr[1]], grid[a][b]);
        if (paths[a][b] > elev) {
          paths[a][b] = elev;
          queue.add(new int[] {a, b});
        }
      }
    }
    return paths[n - 1][n - 1];
  }

  public int swimInWaterHeap(int[][] grid) {
    PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.e - b.e);
    int[] d = new int[] {-1, 0, 1, 0, -1};
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    int max = grid[0][0];
    pq.add(new Cell(grid[0][0], 0, 0));
    while (!pq.isEmpty()) {
      Cell curr = pq.poll();
      visited[curr.a][curr.b] = true;
      max = Math.max(max, curr.e);
      for (int i = 0; i < 4; i++) {
        int a = curr.a + d[i], b = curr.b + d[i + 1];
        if (a < 0 || b < 0 || a == n || b == n) continue;
        if (a == n - 1 && b == n - 1) return Math.max(max, grid[a][b]);
        if (!visited[a][b]) pq.add(new Cell(grid[a][b], a, b));
      }
    }
    return max;
  }

  private record Cell(int e, int a, int b) {}
}
