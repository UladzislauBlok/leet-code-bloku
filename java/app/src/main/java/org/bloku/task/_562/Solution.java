package org.bloku.task._562;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Line of Consecutive One in Matrix")
@Topics({MATRIX, DYNAMIC_PROGRAMMING})
class Solution {

  public int longestLine_traversal(int[][] mat) {
    int longestLine = 0;
    int m = mat.length;
    int n = mat[0].length;
    // horizontal
    for (int row = 0; row < m; row++) {
      longestLine = Math.max(longestLine, traversal(row, 0, 0, 1, mat));
    }

    // vertical
    for (int col = 0; col < n; col++) {
      longestLine = Math.max(longestLine, traversal(0, col, 1, 0, mat));
    }

    // diagonal
    for (int row = 1; row < m; row++) {
      longestLine = Math.max(longestLine, traversal(row, 0, 1, 1, mat));
    }
    for (int col = 0; col < n; col++) {
      longestLine = Math.max(longestLine, traversal(0, col, 1, 1, mat));
    }

    // anti-diagonal
    for (int row = 1; row < m; row++) {
      longestLine = Math.max(longestLine, traversal(row, n - 1, 1, -1, mat));
    }
    for (int col = 0; col < n; col++) {
      longestLine = Math.max(longestLine, traversal(0, col, 1, -1, mat));
    }
    return longestLine;
  }

  private int traversal(int row, int col, int rowDir, int colDir, int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int longestLine = 0;
    int currLine = 0;
    while (row >= 0 && row < m && col >= 0 && col < n) {
      if (mat[row][col] == 0) {
        currLine = 0;
      } else {
        currLine++;
      }
      row += rowDir;
      col += colDir;
      longestLine = Math.max(longestLine, currLine);
    }
    return longestLine;
  }

  // dp one
  public int longestLine(int[][] mat) {
    int longestLine = 0;
    int colLength = mat[0].length;
    int[][] dp = new int[colLength][4]; // 4 directions
    for (int[] row : mat) {
      int diagonal = 0;
      for (int col = 0; col < colLength; col++) {
        int nextDiagonal = dp[col][2];
        if (row[col] == 1) {
          dp[col][0] = col > 0 ? dp[col - 1][0] + 1 : 1;
          dp[col][1] = dp[col][1] + 1;
          dp[col][2] = diagonal + 1;
          dp[col][3] = col < colLength - 1 ? dp[col + 1][3] + 1 : 1;

          longestLine = Math.max(longestLine, dp[col][0]);
          longestLine = Math.max(longestLine, dp[col][1]);
          longestLine = Math.max(longestLine, dp[col][2]);
          longestLine = Math.max(longestLine, dp[col][3]);
        } else {
          dp[col][0] = 0;
          dp[col][1] = 0;
          dp[col][2] = 0;
          dp[col][3] = 0;
        }
        diagonal = nextDiagonal;
      }
    }
    return longestLine;
  }

  /*
      we can do it complicated way with counting dp
      then for every cell we'll need to keep multiple states:
      top, left, diagonal...
      maybe we can do it simpler...
      and just do 4 traversals for every direction
      it's a bit less effective from time complexity POV,
      but it's better from code simplicity and space efficiency
  */
}
