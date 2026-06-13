package org.bloku.task._552;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Student Attendance Record II")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  private static final int MOD = 1_000_000_007;

  public int checkRecord(int n) {
    if (n <= 0) return 0;
    int[][] nextDay = new int[2][3];
    for (int a = 0; a < 2; a++) {
      for (int l = 0; l < 3; l++) {
        nextDay[a][l] = 1;
      }
    }
    for (int day = n - 1; day >= 0; day--) {
      int[][] currDay = new int[2][3];

      for (int a = 0; a < 2; a++) {
        for (int l = 0; l < 3; l++) {
          long total = 0;
          total = (total + nextDay[a][0]) % MOD;
          if (a < 1) {
            total = (total + nextDay[a + 1][0]) % MOD;
          }
          if (l < 2) {
            total = (total + nextDay[a][l + 1]) % MOD;
          }
          currDay[a][l] = (int) total;
        }
      }
      nextDay = currDay;
    }
    return nextDay[0][0];
  }

  public int checkRecord_TopDown(int n) {
    int[][][] memo = new int[n][2][3];
    return countAwards(0, 0, 0, n, memo);
  }

  private int countAwards(int day, int absentsCount, int lateCount, int allDays, int[][][] memo) {
    if (day == allDays) {
      return 1;
    }
    if (memo[day][absentsCount][lateCount] != 0) {
      return memo[day][absentsCount][lateCount];
    }
    int totalCount = 0;
    if (absentsCount == 0) {
      totalCount = countAwards(day + 1, 1, 0, allDays, memo);
    }
    if (lateCount < 2) {
      totalCount =
          (totalCount + countAwards(day + 1, absentsCount, lateCount + 1, allDays, memo)) % MOD;
    }
    totalCount = (totalCount + countAwards(day + 1, absentsCount, 0, allDays, memo)) % MOD;
    memo[day][absentsCount][lateCount] = totalCount;
    return totalCount;
  }

  /*
      it's clearlly dp problem
      there are number of states with constraints which I need to calculate
      for approach for dp is to start simple, meaning start top-down,
      because it's more intuitive and convert it to bottom-up later if needed

      recurcive function and parameters for memorization:
      day, count of absents, count of consecutive lates
  */
}
