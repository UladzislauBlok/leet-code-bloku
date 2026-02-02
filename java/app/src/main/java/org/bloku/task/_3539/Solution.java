package org.bloku.task._3539;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Sum of Array Product of Magical Sequences")
@Topics({ARRAY, MATH, BIT_MANIPULATION, DYNAMIC_PROGRAMMING, DFS, BITMASK})
class Solution {

  private final int MOD = (int) 1e9 + 7;
  private final int[][] C = new int[31][31];
  private final int[][][][] dp = new int[31][31][50][31];

  // credits to An-Wen Deng
  public int magicalSumDfs(int m, int k, int[] nums) {
    int n = nums.length;
    for (int i = 1; i <= m; i++) {
      C[i][0] = C[i][i] = 1;
      for (int j = 1; j <= i / 2; j++) {
        int Cij = C[i - 1][j - 1] + C[i - 1][j]; // pascal triangle
        C[i][j] = C[i][i - j] = Cij;
      }
    }
    for (int[][][] row1 : dp) {
      for (int[][] row2 : row1) {
        for (int[] row3 : row2) {
          Arrays.fill(row3, -1);
        }
      }
    }
    return dfs(m, k, 0, n, 0, nums);
  }

  // m = remaining nuber to choose, k = remaining bitsets to set,
  // i = index for nums, bitMask = shifted bit mask
  private int dfs(int m, int k, int i, int n, int bitMask, int[] nums) {
    int bz = Integer.bitCount(bitMask); // bz is the number of bitsets in bitMask
    if (m < 0 || k < 0 || m + bz < k) // prune for impossible m+bz<k
    return 0;
    if (m == 0) // no more remaining
    return (k == bz) ? 1 : 0;
    if (i >= n) // nums is through
    return 0;

    if (dp[m][k][i][bitMask] != -1) // avoid of redudancy
    return dp[m][k][i][bitMask];

    long ans = 0, powX = 1; // powX = x^f
    int x = nums[i];
    for (int f = 0; f <= m; f++) { // x can be choosen f times
      long perm = C[m][f] * powX % MOD; // binonmial coefficeint* x^f

      int newFlag = bitMask + f; // newFlag
      int nextFlag = newFlag >> 1; // shift
      int bitSet = newFlag & 1; // if newFlag causes current bit set
      // recursive call
      ans = (ans + perm * dfs(m - f, k - bitSet, i + 1, n, nextFlag, nums)) % MOD;
      powX = (powX * x) % MOD; // next powX
    }
    return dp[m][k][i][bitMask] = (int) ans; // write it to dp
  }
}
