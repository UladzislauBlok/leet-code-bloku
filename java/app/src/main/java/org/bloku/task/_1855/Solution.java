package org.bloku.task._1855;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Distance Between a Pair of Values")
@Topics({TWO_POINTERS, BINARY_SEARCH})
class Solution {

  public int maxDistance(int[] nums1, int[] nums2) {
    int p1 = 0, p2 = 0, n1 = nums1.length, n2 = nums2.length;
    int max = 0;
    while (p1 < n1 && p2 < n2) {
      while (p1 < n1 && nums1[p1] > nums2[p2]) p1++;
      if (p1 == n1) break;
      if (p2 < p1) p2 = p1;
      while (p2 < n2 && nums1[p1] <= nums2[p2]) p2++;
      if (p2 <= n2 && nums2[p2 - 1] >= nums1[p1]) max = Math.max(max, p2 - 1 - p1);
    }
    return max;
  }
}
