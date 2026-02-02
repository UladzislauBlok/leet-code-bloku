package org.bloku.task._3542;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Deque;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Operations to Convert All Elements to Zero")
@Topics({STACK, GREEDY})
class Solution {

  // we start with whole nums and re-set min num as 0
  // it's kind of spliting nums into few arrays
  // we can do recursion with subarray
  // problem is that in some cases (e.g., all numbers are unique)
  // it will lead to O(n^2) complexity
  // answer can't be less than number on unique elements,
  // but can be bigger, if two numbers are separated by lower number
  // e.g., [3,1,3,1]
  // I need to do backward loopup to check, if there was lower elem in between
  // can be done with stack

  public int minOperationsStack(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() > num) {
        int prev = stack.pop();
        if (prev != 0) res++;
      }
      if (stack.isEmpty() || stack.peek() < num) stack.push(num);
    }
    for (int num : stack) {
      if (num != 0) res++;
    }
    return res;
  }

  public int minOperations(int[] nums) {
    int res = 0, size = 0, n = nums.length;
    int[] stack = new int[n];
    for (int num : nums) {
      while (size != 0 && stack[size - 1] > num) {
        int prev = stack[size - 1];
        size--;
        if (prev != 0) res++;
      }
      if (size == 0 || stack[size - 1] < num) {
        stack[size] = num;
        size++;
      }
    }
    for (int i = 0; i < size; i++) {
      if (stack[i] != 0) res++;
    }
    return res;
  }
}
