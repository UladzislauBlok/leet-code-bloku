package org.bloku.task._300;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Increasing Subsequence")
@Topics({BINARY_SEARCH, DYNAMIC_PROGRAMMING})
class Solution {

  public int lengthOfLIS(int[] nums) {
    List<Integer> list = new ArrayList<>();
    list.add(nums[0]);
    for (int num : nums) {
      if (num > list.getLast()) {
        list.add(num);
      } else {
        list.set(binarySearch(num, list), num);
      }
    }
    return list.size();
  }

  private int binarySearch(int target, List<Integer> source) {
    int left = 0, right = source.size() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (source.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
