package org.bloku.task._239;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sliding Window Maximum")
@Topics({ARRAY, PREFIX_SUM, SLIDING_WINDOW})
class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int pref[] = new int[nums.length];
    int suf[] = new int[nums.length];
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (i % k == 0) {
        pref[i] = nums[i]; // reset on right side of window
      } else {
        pref[i] = Math.max(pref[i - 1], nums[i]);
      }
    }

    suf[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if ((i + 1) % k == 0) {
        suf[i] = nums[i]; // reset on left side of window
      } else {
        suf[i] = Math.max(suf[i + 1], nums[i]);
      }
    }

    int ans[] = new int[n - k + 1];
    for (int i = 0; i < n - k + 1; i++) {
      ans[i] = Math.max(suf[i], pref[i + k - 1]);
    }
    return ans;
  }
}
