package org.bloku.task._84;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Largest Rectangle in Histogram")
@Topics({ARRAY, STACK})
class Solution {

  public int largestRectangleArea(int[] histogram) {
    int max = Integer.MIN_VALUE, n = histogram.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int[] left = new int[n];
    Arrays.fill(left, -1);
    int[] right = new int[n];
    Arrays.fill(right, n);
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) right[stack.pop()] = i;
      if (!stack.isEmpty()) left[i] = stack.peek();
      stack.push(i);
    }
    for (int i = 0; i < n; i++) {
      max = Math.max(max, histogram[i] * (right[i] - left[i] - 1));
    }
    return max;
  }
}
