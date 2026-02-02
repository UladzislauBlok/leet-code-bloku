package org.bloku.task._2011;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Final Value of Variable After Performing Operations")
@Topics({ARRAY, STRING, SIMULATION})
class Solution {

  public int finalValueAfterOperations(String[] operations) {
    int res = 0;
    for (String operation : operations) {
      if (operation.contains("+")) res++;
      else res--;
    }
    return res;
  }
}
