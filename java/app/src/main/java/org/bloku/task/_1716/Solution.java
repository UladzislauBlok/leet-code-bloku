package org.bloku.task._1716;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Calculate Money in Leetcode Bank")
@Topics({MATH})
class Solution {

  public int totalMoney(int n) {
    int k = n / 7;
    int F = 28;
    int L = 28 + (k - 1) * 7;
    int arithmeticSum = k * (F + L) / 2;
    int monday = 1 + k;
    int finalWeek = 0;
    for (int day = 0; day < n % 7; day++) {
      finalWeek += monday + day;
    }
    return arithmeticSum + finalWeek;
  }

  public int totalMoneyIter(int n) {
    int start = 1;
    int sum = 0;
    int val = start++;
    for (int i = 0; i < n; i++) {
      if (i != 0 && i % 7 == 0) {
        val = start++;
      }
      sum += val++;
    }
    return sum;
  }
}
