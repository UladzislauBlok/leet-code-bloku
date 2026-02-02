package org.bloku.task._407;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Trapping Rain Water II")
@Topics({BFS, HEAP_PRIORITY_QUEUE})
class Solution {

  public int trapRainWater(int[][] heightMap) {
    int m = heightMap.length;
    int n = heightMap[0].length;
    int[][] waterLevel = new int[m][n];
    int sum = 0;

    initWaterLevel(waterLevel, heightMap);
    while (true) {
      boolean hasChanged = false;
      // Forward pass (Assume the water flows towards the top-left.)
      for (int i = 1; i < m - 1; i++) {
        for (int j = 1; j < n - 1; j++) {
          int oldValue = waterLevel[i][j];
          waterLevel[i][j] =
              Math.max(
                  heightMap[i][j],
                  Math.min(waterLevel[i][j], Math.min(waterLevel[i - 1][j], waterLevel[i][j - 1])));
          if (waterLevel[i][j] != oldValue) hasChanged = true;
        }
      }

      if (!hasChanged) break;
      hasChanged = false;
      // Backward pass (Assume the water flows towards the bottom-right.)
      for (int i = m - 2; i >= 1; i--) {
        for (int j = n - 2; j >= 1; j--) {
          int oldValue = waterLevel[i][j];
          waterLevel[i][j] =
              Math.max(
                  heightMap[i][j],
                  Math.min(waterLevel[i][j], Math.min(waterLevel[i + 1][j], waterLevel[i][j + 1])));
          if (waterLevel[i][j] != oldValue) hasChanged = true;
        }
      }
      if (!hasChanged) break;
    }

    // Calculate trapped water
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        sum += waterLevel[i][j] - heightMap[i][j];
      }
    }
    return sum;
  }

  private void initWaterLevel(int[][] waterLevel, int[][] heightMap) {
    int m = heightMap.length;
    int n = heightMap[0].length;
    // Initialize waterLevel as ∞
    for (int i = 0; i < m; i++) {
      Arrays.fill(waterLevel[i], Integer.MAX_VALUE);
    }
    // Update the water level of the surrounding walls to the floor height.
    for (int i = 0; i < m; i++) {
      waterLevel[i][0] = heightMap[i][0];
      waterLevel[i][n - 1] = heightMap[i][n - 1];
    }
    for (int j = 0; j < n; j++) {
      waterLevel[0][j] = heightMap[0][j];
      waterLevel[m - 1][j] = heightMap[m - 1][j];
    }
  }

  public int trapRainWaterHeap(int[][] heightMap) {
    int rows = heightMap.length;
    int cols = heightMap[0].length;
    boolean[][] visited = new boolean[rows][cols];
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
          minHeap.offer(new int[] {heightMap[i][j], i, j});
          visited[i][j] = true;
        }
      }
    }
    int totalWater = 0;
    int[] directions = {-1, 0, 1, 0, -1};
    while (!minHeap.isEmpty()) {
      int[] current = minHeap.poll();
      int currentHeight = current[0];
      int currentRow = current[1];
      int currentCol = current[2];
      for (int k = 0; k < 4; k++) {
        int nextRow = currentRow + directions[k];
        int nextCol = currentCol + directions[k + 1];
        if (nextRow >= 0
            && nextRow < rows
            && nextCol >= 0
            && nextCol < cols
            && !visited[nextRow][nextCol]) {
          totalWater += Math.max(0, currentHeight - heightMap[nextRow][nextCol]);
          visited[nextRow][nextCol] = true;
          minHeap.offer(
              new int[] {Math.max(currentHeight, heightMap[nextRow][nextCol]), nextRow, nextCol});
        }
      }
    }
    return totalWater;
  }
}
