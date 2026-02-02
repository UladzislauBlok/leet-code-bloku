package org.bloku.task._1018;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Binary Prefix Divisible By 5")
@Topics({ARRAY, BIT_MANIPULATION})
class Solution {

  public List<Boolean> prefixesDivBy5(int[] nums) {
    List<Boolean> res = new ArrayList<>();
    int x = 0;
    for (int num : nums) {
      x = (x * 2 + num) % 5;
      res.add(x == 0);
    }
    return res;
  }
}
