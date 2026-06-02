package org.bloku.task._723;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Candy Crush")
@Topics({MATRIX, TWO_POINTERS, SIMULATION})
class Solution {

  public int[][] candyCrush(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    boolean shouldContinue = true;

    while (shouldContinue) {
      shouldContinue = false;

      // Phase 1: Scan and flag horizontal matches
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n - 2; j++) {
          int val = Math.abs(board[i][j]);
          if (val != 0 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
            board[i][j] = -val;
            board[i][j + 1] = -val;
            board[i][j + 2] = -val;
            shouldContinue = true;
          }
        }
      }

      // Phase 2: Scan and flag vertical matches
      for (int i = 0; i < m - 2; i++) {
        for (int j = 0; j < n; j++) {
          int val = Math.abs(board[i][j]);
          if (val != 0 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
            board[i][j] = -val;
            board[i + 1][j] = -val;
            board[i + 2][j] = -val;
            shouldContinue = true;
          }
        }
      }

      // Phase 3: Gravity / Drop Candies
      if (shouldContinue) {
        for (int j = 0; j < n; j++) {
          int writeRow = m - 1;
          for (int i = m - 1; i >= 0; i--) {
            if (board[i][j] > 0) {
              board[writeRow][j] = board[i][j];
              writeRow--;
            }
          }
          // Fill the remaining top cells with 0
          while (writeRow >= 0) {
            board[writeRow][j] = 0;
            writeRow--;
          }
        }
      }
    }

    return board;
  }
}
