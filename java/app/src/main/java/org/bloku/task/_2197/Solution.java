package org.bloku.task._2197;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Replace Non-Coprime Numbers in Array")
@Topics({MATH, STACK})
class Solution {

  public List<Integer> replaceNonCoprimes1(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int num : nums) {
      stack.push(num);
      while (stack.size() > 1) {
        int a = stack.pop();
        int b = stack.pop();
        int gcd = gcd(a, b);
        if (gcd == 1) {
          stack.push(b);
          stack.push(a);
          break;
        } else {
          stack.push(lcm(a, b, gcd));
        }
      }
    }
    List<Integer> res = new ArrayList<>(stack);
    Collections.reverse(res);
    return res;
  }

  public List<Integer> replaceNonCoprimes(int[] nums) {
    int[] stack = new int[nums.length];
    int topPos = -1;
    for (int num : nums) {
      topPos++;
      stack[topPos] = num;
      while (topPos > 0) {
        int a = stack[topPos];
        int b = stack[topPos - 1];
        int gcd = gcd(a, b);
        if (gcd == 1) {
          break;
        } else {
          topPos--;
          stack[topPos] = lcm(a, b, gcd);
        }
      }
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i <= topPos; i++) {
      res.add(stack[i]);
    }
    return res;
  }

  private int gcd(int a, int b) {
    int max = Math.max(a, b);
    int min = Math.min(a, b);
    while (max % min > 0) {
      int temp = min;
      min = max % min;
      max = temp;
    }
    return min;
  }

  private int lcm(int a, int b, int gcd) {
    return (int) (1L * a * b / gcd);
  }
}
