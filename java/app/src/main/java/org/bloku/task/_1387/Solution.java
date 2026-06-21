package org.bloku.task._1387;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sort Integers by The Power Value")
@Topics({DYNAMIC_PROGRAMMING, SORTING})
class Solution {

  private final Map<Integer, Integer> cache = new HashMap<>();

  public int getKth(int lo, int hi, int k) {
    cache.put(1, 0);

    List<int[]> powers = new ArrayList<>();
    for (int i = lo; i <= hi; i++) {
      powers.add(new int[] {getPower(i), i});
    }

    powers.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    return powers.get(k - 1)[1];
  }

  private int getPower(long n) {
    if (n <= Integer.MAX_VALUE && cache.containsKey((int) n)) {
      return cache.get((int) n);
    }
    int steps;
    if (n % 2 == 0) {
      steps = 1 + getPower(n / 2);
    } else {
      steps = 1 + getPower(3 * n + 1);
    }
    if (n <= Integer.MAX_VALUE) {
      cache.put((int) n, steps);
    }
    return steps;
  }
}
