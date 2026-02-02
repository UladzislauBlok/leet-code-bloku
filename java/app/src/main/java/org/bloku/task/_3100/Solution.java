package org.bloku.task._3100;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Water Bottles II")
@Topics({MATH, SIMULATION})
class Solution {

  public int maxBottlesDrunk(int numBottles, int numExchange) {
    int sum = numBottles, bottle = numBottles;
    while (bottle >= numExchange) {
      bottle -= numExchange;
      numExchange++;
      sum++;
      bottle++;
    }
    return sum;
  }
}
