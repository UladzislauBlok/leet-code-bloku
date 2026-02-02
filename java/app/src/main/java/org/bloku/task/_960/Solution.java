package org.bloku.task._960;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Delete Columns to Make Sorted III")
@Topics({ARRAY, STRING, DYNAMIC_PROGRAMMING})
class Solution {

  public int minDeletionSize(String[] strs) {
    int n = strs[0].length();
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int max = 1;
    for (int i = 0; i < n; i++) { // start
      for (int j = i + 1; j < n; j++) { // next
        boolean good = true;
        for (String str : strs) {
          if (str.charAt(j) < str.charAt(i)) {
            good = false;
            break;
          }
        }
        if (good) dp[j] = Math.max(dp[j], dp[i] + 1);
      }
      max = Math.max(max, dp[i]);
    }
    return n - max;
  }

  /*
      dp problem
      we can assume that for every point we have min length 1
      (one symbol is always sorted)
      then we're going to next and do dp[i] = max(dp[i], dp[i - 1] + 1 if  i - 1 is less)

      babca ->
      bbazb ->
      b   a   b   c   a   b
      1   1   1   1   1   1
      b   b   a   z   b   b
      1   1   1   1   1   1

      b   a   b   c   a   b
      1   1   2   3   3   ?? wrong
      solution is to start from every element and
      check if we can jump to any other elements
      b   b   a   z   b   X
      1   1   1   1   1   X

      b   a   b   c   a   b
      1   1   1   2   2   3
      b   b   a   z   b   b
      1   1   1   2   2   3
  */
}
