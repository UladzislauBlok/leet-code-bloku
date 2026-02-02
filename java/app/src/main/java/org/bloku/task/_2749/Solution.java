package org.bloku.task._2749;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Operations to Make the Integer Zero")
@Topics({Topic.MATH, Topic.BIT_MANIPULATION})
class Solution {

  // num1 = 2^i + num2
  // k operations with different i
  // 2^i*k = num1 - num2*k
  // we can brute force up to 60
  // two 2^i−1 can combine to form 2^i
  // if bit num <= i, we can do it in i
  public int makeTheIntegerZero1(int num1, int num2) {
    for (long i = 1; i <= 60; i++) {
      long diff = num1 - num2 * i;
      if (diff <= i) return -1;
      int count = 0;
      while (diff > 0) {
        count += diff & 1;
        diff = diff >> 1;
      }
      // System.out.println(i+":"+diff+":"+count);
      if (count <= i) return (int) i;
    }
    return -1;
  }

  public int makeTheIntegerZero(int num1, int num2) {
    int k = 1;
    while (true) {
      long x = num1 - (long) num2 * k;
      if (x < k) {
        return -1;
      }
      if (k >= Long.bitCount(x)) {
        return k;
      }
      k++;
    }
  }
}
