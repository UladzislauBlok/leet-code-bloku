package org.bloku.task._3753;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Total Waviness of Numbers in Range II")
@Topics({DYNAMIC_PROGRAMMING, MATH})
class Solution {
  public long totalWaviness(long num1, long num2) {
    return solve(num2) - solve(num1 - 1);
  }

  private long solve(long number) {
    if (number < 100) {
      return 0;
    }

    var numStr = String.valueOf(number);
    int length = numStr.length();

    long[][][] memo = new long[length][11][11];
    for (long[][] matrix : memo) {
      for (long[] row : matrix) {
        Arrays.fill(row, -1);
      }
    }

    return digitDp(0, true, true, -1, -1, memo, numStr);
  }

  private long digitDp(
      int idx,
      boolean isLeadingZero,
      boolean isLimit,
      int prevPrev,
      int prev,
      long[][][] memo,
      String numStr) {

    if (idx == numStr.length()) {
      return 0;
    }

    if (!isLimit && !isLeadingZero && memo[idx][prevPrev + 1][prev + 1] != -1) {
      return memo[idx][prevPrev + 1][prev + 1];
    }

    long totalWavinessFromHere = 0;
    int maxDigit = isLimit ? (numStr.charAt(idx) - '0') : 9;

    for (int digit = 0; digit <= maxDigit; digit++) {
      boolean nextLeadingZero = isLeadingZero && (digit == 0);
      boolean nextLimit = isLimit && (digit == maxDigit);

      long currentWaveContribution = 0;
      if (!isLeadingZero && prevPrev != -1) {
        if ((prevPrev < prev && digit < prev) || (prevPrev > prev && digit > prev)) {
          currentWaveContribution = countValidFormations(idx + 1, nextLimit, numStr);
        }
      }

      int nextPrevPrev = isLeadingZero ? -1 : prev;
      int nextPrev = nextLeadingZero ? -1 : digit;

      totalWavinessFromHere +=
          currentWaveContribution
              + digitDp(idx + 1, nextLeadingZero, nextLimit, nextPrevPrev, nextPrev, memo, numStr);
    }

    if (!isLimit && !isLeadingZero) {
      memo[idx][prevPrev + 1][prev + 1] = totalWavinessFromHere;
    }

    return totalWavinessFromHere;
  }

  private long countValidFormations(int idx, boolean isLimit, String numStr) {
    if (isLimit) {
      if (idx == numStr.length()) return 1;
      return Long.parseLong(numStr.substring(idx)) + 1;
    }
    return (long) Math.pow(10, numStr.length() - idx);
  }
}
