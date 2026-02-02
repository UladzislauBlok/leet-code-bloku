package org.bloku.task._3494;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Minimum Amount of Time to Brew Potions")
@Topics({ARRAY, SIMULATION, PREFIX_SUM})
class Solution {

  // n and m <= 5000, O(n^2) will do
  // it's about find the bottleneck
  public long minTimeBottleneck(int[] skill, int[] mana) {
    int n = skill.length, m = mana.length;
    long[] prefixSum = new long[n];
    for (int i = 0; i < m; i++) {
      long prev = 0;
      for (int j = 0; j < n; j++) {
        prev = Math.max(prev, prefixSum[j]) + 1L * skill[j] * mana[i];
      }
      prefixSum[n - 1] = prev;
      for (int j = n - 2; j >= 0; j--)
        prefixSum[j] = prefixSum[j + 1] - 1L * skill[j + 1] * mana[i];
    }
    return prefixSum[n - 1];
  }

  public long minTime(int[] skill, int[] mana) {
    int n = skill.length, m = mana.length;
    long[] prefixSum = new long[n];
    for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + skill[i];
    long diffSum = (long) skill[0] * mana[0];
    for (int j = 1; j < m; j++) {
      long max = (long) skill[0] * mana[j];
      for (int i = 1; i < n; i++) {
        /*
        Difference in effort between
        up to curr wizard for curr-1 potion
        up to curr-1 wizard for curr potion
        */
        long diff = prefixSum[i] * mana[j - 1] - prefixSum[i - 1] * mana[j];
        max = Math.max(max, diff);
      }
      diffSum += max;
    }
    return diffSum + prefixSum[n - 1] * mana[m - 1];
  }
}
