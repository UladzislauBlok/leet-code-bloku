package org.bloku.task._2536;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Increment Submatrices by One")
@Topics({MATRIX, PREFIX_SUM})
class Solution {

  // prefix sum... see comment at the end of class
  public int[][] rangeAddQueries(int n, int[][] queries) {
    int[][] matrix = new int[n][n];
    for (int[] query : queries) {
      matrix[query[0]][query[1]]++;
      if (query[2] < n - 1) matrix[query[2] + 1][query[1]]--;
      if (query[3] < n - 1) matrix[query[0]][query[3] + 1]--;
      if (query[2] < n - 1 && query[3] < n - 1) matrix[query[2] + 1][query[3] + 1]++;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n; j++) {
        matrix[i][j] += matrix[i][j - 1];
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] += matrix[i - 1][j];
      }
    }
    return matrix;
  }

  // let's try straightforward approach -> TLE as expected
  // we can process query with 'marking' approach (query[1] set + 1, query[3]+1 set -1)
  // and process matrix one time
  public int[][] rangeAddQueries1(int n, int[][] queries) {
    int[][] matrix = new int[n][n];
    for (int[] query : queries) {
      for (int i = query[0]; i <= query[2]; i++) {
        matrix[i][query[1]]++;
        if (query[3] < n - 1) matrix[i][query[3] + 1]--;
      }
    }
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        count += matrix[i][j];
        matrix[i][j] = count;
      }
    }
    return matrix;
  }

  /*
      0   0   0
      0   0   0
      0   0   0

      0   0   0
      0   1   0
      0   0   0

      1   0   -1   r -> l     1   1   0    t -> d     1   1   0
      0   1   0   -------->   0   1   1   -------->   1   2   1
      -1  0   1               -1  -1  0               0   1   1
  */ }
