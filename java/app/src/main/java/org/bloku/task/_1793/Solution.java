package org.bloku.task._1793;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Score of a Good Subarray")
@Topics({ARRAY, STACK, TWO_POINTERS})
class Solution {

  public int maximumScore1(int[] nums, int k) {
    int max = Integer.MIN_VALUE, n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int[] left = new int[n];
    Arrays.fill(left, -1);
    int[] right = new int[n];
    Arrays.fill(right, n);
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) right[stack.pop()] = i;
      if (!stack.isEmpty()) left[i] = stack.peek();
      stack.push(i);
    }
    for (int i = 0; i < n; i++) {
      if (left[i] >= k || right[i] <= k) continue;
      max = Math.max(max, nums[i] * (right[i] - left[i] - 1));
    }
    return max;
  }

  public int maximumScore(int[] A, int k) {
    int res = A[k], mini = A[k], i = k, j = k, n = A.length;
    while (i > 0 || j < n - 1) {
      if (i == 0) ++j;
      else if (j == n - 1) --i;
      else if (A[i - 1] < A[j + 1]) ++j;
      else --i;
      mini = Math.min(mini, Math.min(A[i], A[j]));
      res = Math.max(res, mini * (j - i + 1));
    }
    return res;
  }
}
