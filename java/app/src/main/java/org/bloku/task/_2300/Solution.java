package org.bloku.task._2300;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Successful Pairs of Spells and Potions")
@Topics({ARRAY, SORTING, BINARY_SEARCH})
class Solution {

  // Idea:
  // Sort potions and do binary search
  // O(n log n)
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int n = spells.length;
    int m = potions.length;
    int[] res = new int[n];
    Arrays.sort(potions);
    for (int i = 0; i < n; i++) {
      long spell = spells[i] * 1L;
      if (spell * potions[m - 1] < success) continue;
      if (spell * potions[0] >= success) {
        res[i] = m;
        continue;
      }
      res[i] = m - search(spell, success, potions);
    }
    return res;
  }

  private int search(long spell, long success, int[] potions) {
    int left = 0, right = potions.length - 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      long product = spell * potions[mid];
      if (product >= success) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
