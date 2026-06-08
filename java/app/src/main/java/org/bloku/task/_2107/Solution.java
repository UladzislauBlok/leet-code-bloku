package org.bloku.task._2107;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Unique Flavors After Sharing K Candies")
@Topics({HASH_TABLE, SLIDING_WINDOW})
class Solution {

  public int shareCandies(int[] candies, int k) {
    if (candies == null || candies.length == 0) {
      return 0;
    }
    var frequencyMap = new HashMap<Integer, Integer>();
    for (int candy : candies) {
      frequencyMap.merge(candy, 1, Integer::sum);
    }
    if (k == 0) {
      return frequencyMap.size();
    }
    int maxUniqueRemaining = 0;
    for (int right = 0; right < candies.length; right++) {
      int incomingCandy = candies[right];
      int currentFreq = frequencyMap.merge(incomingCandy, -1, Integer::sum);
      if (currentFreq == 0) {
        frequencyMap.remove(incomingCandy);
      }
      if (right >= k) {
        int outgoingCandy = candies[right - k];
        frequencyMap.merge(outgoingCandy, 1, Integer::sum);
      }
      if (right >= k - 1) {
        maxUniqueRemaining = Math.max(maxUniqueRemaining, frequencyMap.size());
      }
    }
    return maxUniqueRemaining;
  }
}
