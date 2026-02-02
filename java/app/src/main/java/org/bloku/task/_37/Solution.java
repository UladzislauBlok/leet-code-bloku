package org.bloku.task._37;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sudoku Solver")
@Topics({HASH_TABLE, BACKTRACKING})
class Solution {

  private boolean res = false;
  private char[][] board;
  private boolean[][] rows = new boolean[9][10];
  private boolean[][] cols = new boolean[9][10];
  private boolean[][] boxes = new boolean[9][10];

  // size is 9x9, we can try to brut force it
  public void solveSudoku(char[][] board) {
    this.board = board;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c = board[i][j];
        if (c != '.') {
          rows[i][c - '0'] = true;
          cols[j][c - '0'] = true;
          boxes[i / 3 * 3 + j / 3][c - '0'] = true;
        }
      }
    }
    backtrack(0, 0);
  }

  private void backtrack(int a, int b) {
    if (a == 9) res = true;
    if (res) return;
    char c = board[a][b];
    if (c != '.') {
      if (b == 8) {
        backtrack(a + 1, 0);
      } else {
        backtrack(a, b + 1);
      }
      return;
    }
    for (int i = 1; i <= 9; i++) {
      if (rows[a][i] || cols[b][i] || boxes[a / 3 * 3 + b / 3][i]) continue;
      rows[a][i] = true;
      cols[b][i] = true;
      boxes[a / 3 * 3 + b / 3][i] = true;
      board[a][b] = (char) ('0' + i);
      if (b == 8) {
        backtrack(a + 1, 0);
      } else {
        backtrack(a, b + 1);
      }
      if (res) return;
      rows[a][i] = false;
      cols[b][i] = false;
      boxes[a / 3 * 3 + b / 3][i] = false;
      board[a][b] = '.';
    }
  }
}
