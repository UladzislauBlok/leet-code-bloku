package org.bloku.task._3397;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Number of Distinct Elements After Operations")
@Topics({ARRAY, SORTING, GREEDY})
class Solution {

  // check the interval
  // as k is pretty big 0 <= k <= 10^9
  // we can optimase it from O(N*K) to O(N log N)
  // using sorting
  public int maxDistinctElements(int[] nums, int k) {
    Arrays.sort(nums);
    int max = Integer.MIN_VALUE;
    int count = 0;
    for (int num : nums) {
      max = Math.max(max + 1, num - k);
      if (max <= num + k) count++;
      else max = num + k;
    }
    return count;
  }
}
