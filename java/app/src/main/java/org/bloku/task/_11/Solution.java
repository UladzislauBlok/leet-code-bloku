package org.bloku.task._11;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Container With Most Water")
@Topics({GREEDY, TWO_POINTERS})
class Solution {

  // here two things are important: height and length
  // we can use two pointer
  // start on left and right side
  // move one pointer with smallest height
  // check if curr res is more than prev
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int res = 0;
    while (left < right) {
      int min = Math.min(height[left], height[right]);
      int curr = (right - left) * min;
      res = Math.max(res, curr);
      while (left < right && height[left] <= min) left++;
      while (left < right && height[right] <= min) right--;
    }
    return res;
  }
}
