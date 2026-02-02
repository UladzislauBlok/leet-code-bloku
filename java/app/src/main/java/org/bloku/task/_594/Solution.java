package org.bloku.task._594;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Harmonious Subsequence")
@Topics({ARRAY, HASH_TABLE, SLIDING_WINDOW, SORTING, COUNTING})
class Solution {

  public int findLHSSort(int[] nums) { // O(n logn)
    int n = nums.length;
    Arrays.sort(nums);
    if (nums[0] == nums[n - 1]) return 0;
    int max = 0;
    int left = 0;
    int right = 1;
    while (right != n) {
      while (right != n && nums[right] - nums[left] <= 1) right++;
      if (nums[left] != nums[right - 1]) max = Math.max(max, right - left);
      while (right != n && nums[right] - nums[left] > 1) left++;
    }
    return max;
  }

  public int findLHS(int[] nums) { // O(n logn)
    int n = nums.length;
    Arrays.sort(nums);
    int max = 0;
    int left = 0;
    int right = 1;
    while (right != n) {
      if (nums[left] == nums[right]) {
        right++;
      } else if (nums[right] - nums[left] > 1) {
        left++;
      } else {
        max = Math.max(max, right - left + 1);
        right++;
      }
    }
    return max;
  }

  public int findLHSMap(int[] nums) { // O(n)
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int max = 0;
    for (int num : map.keySet()) {
      if (map.containsKey(num - 1)) {
        max = Math.max(max, map.get(num) + map.get(num - 1));
      }
      if (map.containsKey(num + 1)) {
        max = Math.max(max, map.get(num) + map.get(num + 1));
      }
    }
    return max;
  }
}
