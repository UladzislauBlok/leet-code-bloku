package org.bloku.task._1833;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Ice Cream Bars")
@Topics({ARRAY, GREEDY, SORTING, COUNTING})
class Solution {

  public int maxIceCream(int[] costs, int coins) {
    int max = 0;
    for (int cost : costs) {
      max = Math.max(max, cost);
    }
    int[] buckets = new int[max + 1];
    for (int cost : costs) {
      buckets[cost]++;
    }
    int iceCreams = 0;
    for (int cost = 0; cost <= max; cost++) {
      if (coins >= buckets[cost] * cost) {
        iceCreams += buckets[cost];
        coins -= buckets[cost] * cost;
      } else {
        iceCreams += coins / cost;
        break;
      }
    }
    return iceCreams;
  }
}
