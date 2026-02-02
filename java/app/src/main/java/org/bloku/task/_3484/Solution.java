package org.bloku.task._3484;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Design Spreadsheet")
@Topics({STRING, DESIGN, HASH_TABLE})
class Solution {

  static class Spreadsheet {
    private final int[][] grid;

    public Spreadsheet(int rows) {
      this.grid = new int[rows + 1][26];
    }

    public void setCell(String cell, int value) {
      int row = Integer.valueOf(cell.substring(1));
      int col = cell.charAt(0) - 'A';
      grid[row][col] = value;
    }

    public void resetCell(String cell) {
      int row = Integer.valueOf(cell.substring(1));
      int col = cell.charAt(0) - 'A';
      grid[row][col] = 0;
    }

    public int getValue(String formula) {
      int delimiter = formula.indexOf("+");
      String s1 = formula.substring(1, delimiter);
      String s2 = formula.substring(delimiter + 1);
      int n1;
      int n2;
      if (s1.charAt(0) <= '9') {
        n1 = Integer.valueOf(s1);
      } else {
        int row = Integer.valueOf(s1.substring(1));
        int col = s1.charAt(0) - 'A';
        n1 = grid[row][col];
      }
      if (s2.charAt(0) <= '9') {
        n2 = Integer.valueOf(s2);
      } else {
        int row = Integer.valueOf(s2.substring(1));
        int col = s2.charAt(0) - 'A';
        n2 = grid[row][col];
      }
      return n1 + n2;
    }
  }
}
