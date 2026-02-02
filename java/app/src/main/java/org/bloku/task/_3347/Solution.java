package org.bloku.task._3347;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Frequency of an Element After Performing Operations II")
@Topics({ARRAY, RBT, SORTING, SLIDING_WINDOW})
class Solution {

  // same as 3346, but max number is bigger
  // frequency array cannot be used, because out of memory error
  // idea is the same, but it makes sense to process only presented number
  // we can use sorted map as frequency
  // then do the sliding window within the existing numbers
  public int maxFrequency(int[] nums, int k, int numOperations) {
    TreeMap<Integer, Integer> f = new TreeMap<>();
    for (int num : nums) {
      f.merge(num, 1, Integer::sum);
    }
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(f.sequencedEntrySet());
    int right = 0, left1 = 0, left2 = 0, curr = 0, window1 = 0, window2 = 0;
    int n = list.size();
    int max = 0;
    while (curr < n) {
      window2 += list.get(curr).getValue();
      while (right < n && list.get(right).getKey() - list.get(curr).getKey() <= k) {
        window1 += list.get(right).getValue();
        right++;
      }
      while (list.get(curr).getKey() - list.get(left1).getKey() > k) {
        window1 -= list.get(left1).getValue();
        left1++;
      }
      while (list.get(curr).getKey() - list.get(left2).getKey() > k * 2) {
        window2 -= list.get(left2).getValue();
        left2++;
      }
      int currValue = list.get(curr).getValue();
      max = Math.max(max, currValue + Math.min(window1 - currValue, numOperations));
      max = Math.max(max, Math.min(window2, numOperations));
      curr++;
    }
    return max;
  }

  public int maxFrequencyArray(int[] nums, int k, int ops) {
    int res = 0;
    Arrays.sort(nums);
    int left = 0;
    int right = 0;
    int n = nums.length;
    int i = 0;
    // case 1, num is in the arr
    while (i < n) {
      int val = nums[i];
      int same = 0;
      while (i < n && nums[i] == val) {
        same++;
        i++;
      }
      while (right < n && nums[right] <= val + k) {
        right++;
      }
      while (left < n && nums[left] < val - k) {
        left++;
      }
      res = Math.max(res, Math.min(same + ops, right - left));
    }
    // case 2, num is not in the arr
    left = 0;
    right = 0;
    while (right < n) {
      while (right < n && (long) nums[left] + k + k >= nums[right]) {
        right++;
      }
      res = Math.max(res, Math.min(right - left, ops));
      left++;
    }
    return res;
  }
}
