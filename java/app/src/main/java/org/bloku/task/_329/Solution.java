package org.bloku.task._329;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Increasing Path in a Matrix")
@Topics({MATRIX, DYNAMIC_PROGRAMMING, TOPOLOGICAL_SORT})
class Solution {

  private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] indegree = new int[m][n];
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        for (int[] dir : DIRECTIONS) {
          int nextRow = row + dir[0];
          int nextCol = col + dir[1];
          if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
            if (matrix[nextRow][nextCol] > matrix[row][col]) {
              indegree[nextRow][nextCol]++;
            }
          }
        }
      }
    }
    Queue<Integer> queue = new ArrayDeque<>();
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (indegree[row][col] == 0) {
          queue.offer(row * n + col);
        }
      }
    }

    int longestPath = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      longestPath++;

      for (int i = 0; i < size; i++) {
        int head = queue.poll();
        int currRow = head / n;
        int currCol = head % n;

        for (int[] dir : DIRECTIONS) {
          int nextRow = currRow + dir[0];
          int nextCol = currCol + dir[1];

          if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
            if (matrix[nextRow][nextCol] > matrix[currRow][currCol]) {
              indegree[nextRow][nextCol]--;
              if (indegree[nextRow][nextCol] == 0) {
                queue.offer(nextRow * n + nextCol);
              }
            }
          }
        }
      }
    }
    return longestPath;
  }
}
