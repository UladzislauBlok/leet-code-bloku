package org.bloku.task._611;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Valid Triangle Number")
@Topics({SORTING, BINARY_SEARCH, TWO_POINTERS})
class Solution {

  // O(n^2*log(N))
  public int triangleNumber1(int[] nums) {
    int count = 0;
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] == 0) continue;
      for (int j = i + 1; j < n; j++) {
        int sum = nums[i] + nums[j];
        if (sum > nums[n - 1]) {
          count += n - j - 1;
        } else {
          int idx = Arrays.binarySearch(nums, sum);
          if (idx < 0) idx = -1 * idx - 2;
          while (idx >= 0 && sum == nums[idx]) idx--;
          count += idx - j;
        }
      }
    }
    return count;
  }

  // O(n^2)
  public int triangleNumber(int[] nums) {
    int res = 0;
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = n - 1; i >= 2; i--) {
      int left = 0, right = i - 1;
      while (left < right) {
        if (nums[left] + nums[right] > nums[i]) {
          res += (right - left);
          right--;
        } else {
          left++;
        }
      }
    }
    return res;
  }
}
