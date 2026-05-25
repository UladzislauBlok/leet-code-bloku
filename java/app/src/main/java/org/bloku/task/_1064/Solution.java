package org.bloku.task._1064;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Fixed Point")
@Topics({ARRAY, BINARY_SEARCH})
class Solution {

  public int fixedPoint(int[] array) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < mid) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (left < array.length && array[left] == left) {
      return left;
    }
    return -1;
  }
}
