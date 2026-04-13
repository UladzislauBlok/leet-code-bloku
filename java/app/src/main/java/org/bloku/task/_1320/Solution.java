package org.bloku.task._1320;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Distance to Type a Word Using Two Fingers")
@Topics({STRING, DYNAMIC_PROGRAMMING})
class Solution {

  private char[] chars;
  private final int[][] memo = new int[301][301];

  public int minimumDistance(String word) {
    chars = word.toCharArray();
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    int n = chars.length;
    int[] prefix = new int[n];
    for (int i = 1; i < n; i++) {
      prefix[i] += prefix[i - 1] + distance(position(chars[i - 1]), position(chars[i]));
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) min = Math.min(min, dp(i - 1, i) + prefix[i - 1]);
    return min;
  }

  private int dp(int left, int right) {
    int next = Math.max(left, right) + 1;
    if (next == chars.length) return 0;
    if (memo[left][right] != -1) return memo[left][right];
    int[] leftP = position(chars[left]);
    int[] rightP = position(chars[right]);
    int[] nextP = position(chars[next]);
    int leftRes = dp(next, right) + distance(leftP, nextP);
    int rightRes = dp(left, next) + distance(rightP, nextP);
    int min = Math.min(leftRes, rightRes);
    memo[left][right] = min;
    return min;
  }

  private int distance(int[] a, int[] b) {
    if (a == null) return 0;
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }

  private int[] position(char c) {
    return new int[] {(c - 'A') / 6, (c - 'A') % 6};
  }

  /*
      two fingers mean we need to split chars to one of two groups
      can we be greedy and find two points with max distance and use a base?
      but one of the examples breaks this idea: HAPPY
      H -> P == 4
      H -> Y == 4
      Maybe we can just try every variation?
      that would be n^3, but with word.length <= 300 we should be gucci
      hmmm...
      actually we can see on that as dp problem:
      we start on any of two points, and later we have a choose to move
      ether left or right finger
  */
}
