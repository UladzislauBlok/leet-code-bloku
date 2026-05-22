package org.bloku.task._33;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Search in Rotated Sorted Array")
@Topics({BINARY_SEARCH})
class Solution {

  public int search(int[] nums, int target) {
    int n = nums.length;
    int left = 0, right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] <= nums[n - 1]) {
        if (target <= nums[n - 1] && nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if (target > nums[n - 1] && nums[mid] >= target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return nums[left] == target ? left : -1;
  }
}
