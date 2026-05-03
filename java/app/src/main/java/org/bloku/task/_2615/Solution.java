package org.bloku.task._2615;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sum of Distances")
@Topics({ARRAY, HASH_TABLE, PREFIX_SUM})
class Solution {

  public long[] distance(int[] nums) {
    int n = nums.length;
    long[] resultLeft = new long[n];
    Map<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      int[] prevPos = map.getOrDefault(num, new int[] {i, 0});
      resultLeft[i] += resultLeft[prevPos[0]];
      resultLeft[i] += (i - prevPos[0]) * prevPos[1];
      prevPos[0] = i;
      prevPos[1]++;
      map.put(num, prevPos);
    }
    map.clear();
    long[] resultRight = new long[n];
    for (int i = n - 1; i >= 0; i--) {
      int num = nums[i];
      int[] prevPos = map.getOrDefault(num, new int[] {i, 0});
      resultRight[i] += resultRight[prevPos[0]];
      resultRight[i] += (prevPos[0] - i) * prevPos[1];
      prevPos[0] = i;
      prevPos[1]++;
      map.put(num, prevPos);
    }
    long[] result = new long[n];
    for (int i = 0; i < n; i++) {
      result[i] = resultLeft[i] + resultRight[i];
    }
    return result;
  }
}
