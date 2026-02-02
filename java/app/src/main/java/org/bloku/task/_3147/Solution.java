package org.bloku.task._3147;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Taking Maximum Energy From the Mystic Dungeon")
@Topics({ARRAY, PREFIX_SUM})
class Solution {

  public int maximumEnergyPrefixSum(int[] energy, int k) {
    int n = energy.length;
    int[] prefixSum = new int[n];
    for (int i = 0; i < n; i++) {
      prefixSum[i] = i - k >= 0 ? prefixSum[i - k] : 0;
      prefixSum[i] = Math.max(energy[i], prefixSum[i] + energy[i]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = n - 1; i >= 0 && n - i <= k; i--) {
      max = Math.max(max, prefixSum[i]);
    }
    return max;
  }

  public int maximumEnergy(int[] energy, int k) {
    int n = energy.length, m = n - k, max = -1000;
    for (int i = m; i < n; i++) {
      for (int j = i, tmp = 0; j > -1; j -= k) {
        tmp += energy[j];
        max = Math.max(max, tmp);
      }
    }
    return max;
  }
}
