package org.bloku.task._2540;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Common Value")
@Topics({TWO_POINTERS})
class Solution {

  public int getCommon_(int[] nums1, int[] nums2) {
    // Each variable on its own line per Google Style Guide 4.8.2.1
    int idx1 = 0;
    int idx2 = 0;

    int len1 = nums1.length;
    int len2 = nums2.length;

    while (idx1 < len1 && idx2 < len2) {
      if (nums1[idx1] < nums2[idx2]) {
        idx1++;
      } else if (nums1[idx1] > nums2[idx2]) {
        idx2++;
      } else {
        return nums1[idx1];
      }
    }

    return -1;
  }

  public int getCommon(int[] nums1, int[] nums2) {
    int[] smaller = nums1.length <= nums2.length ? nums1 : nums2;
    int[] larger = nums1.length > nums2.length ? nums1 : nums2;

    int searchOffset = 0;

    for (int num : smaller) {
      int targetIdx = findLowerBound(larger, searchOffset, num);
      if (targetIdx >= larger.length) {
        break;
      }
      if (num == larger[targetIdx]) {
        return num;
      }
      searchOffset = targetIdx;
    }

    return -1;
  }

  /**
   * Finds the first index in nums containing a value >= target, starting from 'low'. Returns
   * nums.length if no such element exists.
   */
  private int findLowerBound(int[] nums, int low, int target) {
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }
}
