package org.bloku.task._1293;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Shortest Path in a Grid with Obstacles Elimination")
@Topics({ARRAY, MATRIX, BFS})
class Solution {

  public int shortestPath(int[][] grid, int k) {
    int m = grid.length, n = grid[0].length;
    int[][] visited = new int[m][n];
    for (int[] row : visited) {
      Arrays.fill(row, -1);
    }
    int[][] directions = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {0, 0, k});
    int count = -1;
    while (!queue.isEmpty()) {
      count++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] cell = queue.poll();
        if (cell[0] == m - 1 && cell[1] == n - 1) return count;
        for (int[] direction : directions) {
          int nextRow = cell[0] + direction[0];
          int nextCol = cell[1] + direction[1];
          int[] next = new int[] {nextRow, nextCol, cell[2]};
          if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n) continue;
          if (grid[nextRow][nextCol] == 1) next[2]--;
          if (next[2] < 0 || visited[nextRow][nextCol] >= next[2]) continue;
          visited[nextRow][nextCol] = next[2];
          queue.add(next);
        }
      }
    }
    return -1;
  }
}
