package org.bloku.task._3633;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Earliest Finish Time for Land and Water Rides I")
@Topics({ARRAY, GREEDY})
class Solution {

  public int earliestFinishTime(
      int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
    int earliestEnd = Integer.MAX_VALUE;

    // Case 1: Start with land ride, then do water ride
    int earliestEndOfLand = findEarliestEnd(landStartTime, landDuration);
    for (int i = 0; i < waterStartTime.length; i++) {
      int currEnd = Math.max(waterStartTime[i], earliestEndOfLand) + waterDuration[i];
      earliestEnd = Math.min(earliestEnd, currEnd);
    }

    // Case 2: Start with water ride, then do land ride
    int earliestEndOfWater = findEarliestEnd(waterStartTime, waterDuration);
    for (int i = 0; i < landStartTime.length; i++) {
      int currEnd = Math.max(landStartTime[i], earliestEndOfWater) + landDuration[i];
      earliestEnd = Math.min(earliestEnd, currEnd);
    }

    return earliestEnd;
  }

  private int findEarliestEnd(int[] startTime, int[] duration) {
    int earliestEnd = Integer.MAX_VALUE;
    for (int i = 0; i < startTime.length; i++) {
      earliestEnd = Math.min(earliestEnd, startTime[i] + duration[i]);
    }
    return earliestEnd;
  }
}
