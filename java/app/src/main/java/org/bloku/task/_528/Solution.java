package org.bloku.task._528;

import static org.bloku.util.Topic.*;

import java.util.Random;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Random Pick with Weight")
@Topics({ARRAY, MATH, BINARY_SEARCH, PREFIX_SUM})
class Solution {

  private final Random rand = new Random();
  private final int[] prefix;
  private final int max;

  public Solution(int[] w) {
    this.prefix = w;
    for (int i = 1; i < w.length; i++) prefix[i] += prefix[i - 1];
    max = prefix[prefix.length - 1];
  }

  public int pickIndex() {
    if (prefix.length == 1) return 0;
    int target = rand.nextInt(max);
    int low = 0, high = prefix.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (prefix[mid] <= target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}
