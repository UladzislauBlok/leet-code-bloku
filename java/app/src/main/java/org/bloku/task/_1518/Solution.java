package org.bloku.task._1518;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Water Bottles")
@Topics({MATH, SIMULATION})
class Solution {

  public int numWaterBottles(int numBottles, int numExchange) {
    int count = 0;
    int rest = 0;
    while (numBottles > 0) {
      count += numBottles;
      int curr = numBottles + rest;
      numBottles = curr / numExchange;
      rest = curr % numExchange;
    }
    return count;
  }
}
