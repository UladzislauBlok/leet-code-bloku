package org.bloku.task._326;

import static org.bloku.util.Topic.MATH;

import java.util.HashSet;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Power of Three")
@Topics({MATH})
class Solution {
  private static final Set<Integer> pows = calculatePows3();

  public boolean isPowerOfThree(int n) {
    return pows.contains(n);
  }

  public boolean isPowerOfThree1(int n) {
    if (n <= 0) return false;
    while (n % 3 == 0) n /= 3;
    return n == 1;
  }

  private static Set<Integer> calculatePows3() {
    Set<Integer> pows = new HashSet<>();
    long num = 1;
    while (num <= Integer.MAX_VALUE) {
      pows.add((int) num);
      num *= 3;
    }
    return pows;
  }
}
