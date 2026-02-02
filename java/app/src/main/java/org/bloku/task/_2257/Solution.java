package org.bloku.task._2257;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Unguarded Cells in the Grid")
@Topics({ARRAY, MATRIX, SIMULATION})
class Solution {

  // we need to preprocess grid
  // probably we can do O((m*n)^2), but it's too ineffective
  // we can mark guards on array or map respresenting rows and cols
  // and do lookup
  // proposed sol is brute force.... -_-
  // okay actually in brute force time complexity is pretty good,
  // because we'll stop processing if we see any type of obstacle
  public int countUnguardedRBT(int m, int n, int[][] guards, int[][] walls) {
    Map<Integer, TreeSet<Integer>> rowGuards = new HashMap<>();
    Map<Integer, TreeSet<Integer>> colGuards = new HashMap<>();
    Map<Integer, TreeSet<Integer>> rowWalls = new HashMap<>();
    Map<Integer, TreeSet<Integer>> colWalls = new HashMap<>();
    for (int[] guard : guards) {
      rowGuards.putIfAbsent(guard[0], new TreeSet<>());
      rowGuards.get(guard[0]).add(guard[1]);
      colGuards.putIfAbsent(guard[1], new TreeSet<>());
      colGuards.get(guard[1]).add(guard[0]);
    }
    for (int[] wall : walls) {
      rowWalls.putIfAbsent(wall[0], new TreeSet<>());
      rowWalls.get(wall[0]).add(wall[1]);
      colWalls.putIfAbsent(wall[1], new TreeSet<>());
      colWalls.get(wall[1]).add(wall[0]);
    }
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Integer lowerRowGuard = rowGuards.getOrDefault(i, new TreeSet<>()).floor(j);
        Integer higherRowGuard = rowGuards.getOrDefault(i, new TreeSet<>()).higher(j);
        Integer lowerColGuard = colGuards.getOrDefault(j, new TreeSet<>()).floor(i);
        Integer higherColGuard = colGuards.getOrDefault(j, new TreeSet<>()).higher(i);

        Integer lowerRowWall = rowWalls.getOrDefault(i, new TreeSet<>()).floor(j);
        Integer higherRowWall = rowWalls.getOrDefault(i, new TreeSet<>()).higher(j);
        Integer lowerColWall = colWalls.getOrDefault(j, new TreeSet<>()).floor(i);
        Integer higherColWall = colWalls.getOrDefault(j, new TreeSet<>()).higher(i);

        if (lowerRowGuard != null && lowerRowGuard == j) continue;
        if (lowerColGuard != null && lowerColGuard == i) continue;
        if (lowerRowWall != null && lowerRowWall == j) continue;
        if (lowerColWall != null && lowerColWall == i) continue;

        if (lowerRowGuard != null && lowerRowWall == null) continue;
        if (lowerRowGuard != null && lowerRowGuard > lowerRowWall) continue;
        if (higherRowGuard != null && higherRowWall == null) continue;
        if (higherRowGuard != null && higherRowGuard < higherRowWall) continue;

        if (lowerColGuard != null && lowerColWall == null) continue;
        if (lowerColGuard != null && lowerColGuard > lowerColWall) continue;
        if (higherColGuard != null && higherColWall == null) continue;
        if (higherColGuard != null && higherColGuard < higherColWall) continue;
        count++;
      }
    }
    return count;
  }

  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    int[][] matrix = new int[m][n];
    for (int[] wall : walls) matrix[wall[0]][wall[1]] = -1;

    for (int[] guard : guards) matrix[guard[0]][guard[1]] = -1;

    for (int[] guard : guards) {
      fillGuarded(guard, matrix);
    }

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) count++;
      }
    }

    return count;
  }

  private void fillGuarded(int[] guard, int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int row = guard[0];
    int col = guard[1];

    for (int i = col + 1; i < cols; i++) {
      if (matrix[row][i] == -1) break;
      matrix[row][i] = 1;
    }

    for (int i = col - 1; i >= 0; i--) {
      if (matrix[row][i] == -1) break;
      matrix[row][i] = 1;
    }

    for (int i = row + 1; i < rows; i++) {
      if (matrix[i][col] == -1) break;
      matrix[i][col] = 1;
    }

    for (int i = row - 1; i >= 0; i--) {
      if (matrix[i][col] == -1) break;
      matrix[i][col] = 1;
    }
  }
}
