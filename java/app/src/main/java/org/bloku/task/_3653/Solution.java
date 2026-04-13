package org.bloku.task._3653;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("XOR After Range Multiplication Queries I")
@Topics({ARRAY, SIMULATION})
class Solution {

  public int xorAfterQueries(int[] nums, int[][] queries) {
    final int mod = (int) 1e9 + 7;
    for (int[] query : queries) {
      for (int i = query[0]; i <= query[1]; i += query[2]) {
        long num = nums[i];
        num *= query[3];
        nums[i] = (int) (num % mod);
      }
    }
    int result = 0;
    for (int num : nums) result ^= num;
    return result;
  }
}
