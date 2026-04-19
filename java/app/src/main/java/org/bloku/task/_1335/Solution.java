package org.bloku.task._1335;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Difficulty of a Job Schedule")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  private int[] jobDifficulty;
  private int[][][] memo;

  public int minDifficulty_(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (d > n) return -1;
    this.jobDifficulty = jobDifficulty;
    int max = 0;
    for (int job : jobDifficulty) max = Math.max(max, job);
    this.memo = new int[n][max + 1][d + 1];
    for (int[][] matrix : memo) {
      for (int[] row : matrix) Arrays.fill(row, -1);
    }
    return dp(0, 0, d);
  }

  private int dp(int idx, int max, int d) {
    int n = jobDifficulty.length;
    if (idx == n && d == 0) return 0;
    if (idx == n || d == 0) return (int) 1e6;
    if (memo[idx][max][d] != -1) return memo[idx][max][d];
    max = Math.max(max, jobDifficulty[idx]);
    int best = dp(idx + 1, 0, d - 1) + max;
    best = Math.min(best, dp(idx + 1, max, d));
    memo[idx][max][d] = best;
    return best;
  }

  public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d) return -1;
    int[][] dp = new int[n][d + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return diff(jobDifficulty, d, 0, dp);
  }

  int diff(int[] jobs, int d, int j, int[][] dp) {
    if (d == 1) {
      int max = 0;
      for (int i = j; i < jobs.length; i++) {
        max = Math.max(max, jobs[i]);
      }
      return max;
    }
    if (dp[j][d] != -1) return dp[j][d];
    int result = Integer.MAX_VALUE;
    int max = 0;
    for (int i = j; i <= jobs.length - d; i++) {
      max = Math.max(max, jobs[i]);
      int next = diff(jobs, d - 1, i + 1, dp);
      result = Math.min(result, max + next);
    }
    return dp[j][d] = result;
  }
}
