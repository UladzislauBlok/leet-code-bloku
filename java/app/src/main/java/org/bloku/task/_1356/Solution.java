package org.bloku.task._1356;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sort Integers by The Number of 1 Bits")
@Topics({ARRAY, BIT_MANIPULATION, SORTING, COUNTING})
class Solution {

  public int[] sortByBits(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int count = 0, num = arr[i];
      while (num > 0) {
        count += num & 1;
        num >>= 1;
      }
      arr[i] = count * 1000000 + arr[i];
    }
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] % 1000000;
    }
    return arr;
  }
}
