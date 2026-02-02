package org.bloku.task._3314;

import static org.bloku.util.Topic.*;

import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Construct the Minimum Bitwise Array I")
@Topics({ARRAY, BIT_MANIPULATION})
class Solution {

  public int[] minBitwiseArray(List<Integer> nums) {
    int n = nums.size();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = -1;
      int num = nums.get(i);
      for (int j = 0; j <= num; j++) {
        if (num == (j | (j + 1))) {
          res[i] = j;
          break;
        }
      }
    }
    return res;
  }
}
