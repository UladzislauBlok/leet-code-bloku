package org.bloku.task._3190;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Minimum Operations to Make All Elements Divisible by Three")
@Topics({ARRAY, MATH})
class Solution {

  // this is about find closest num that is divisible by 3
  public int minimumOperations(int[] nums) {
    int count = 0;
    for (int num : nums) count += num % 3 == 0 ? 0 : 1;
    return count;
  }
}
