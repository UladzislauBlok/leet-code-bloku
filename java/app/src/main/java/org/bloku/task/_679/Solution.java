package org.bloku.task._679;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("24 Game")
@Topics({MATH, BACKTRACKING})
class Solution {

  private boolean result = false;

  // cards.length == 4
  // brute force
  public boolean judgePoint24(int[] cards) {
    List<Double> cardsList = new ArrayList<>();
    for (int card : cards) cardsList.add((double) card);
    judgePoint24(cardsList);
    return result;
  }

  private void judgePoint24(List<Double> cards) {
    if (result) return;
    if (cards.size() == 1 && Math.abs(cards.getFirst() - 24) < 1e-4) {
      result = true;
      return;
    }
    for (int i = 0; i < cards.size(); i++) {
      for (int j = i + 1; j < cards.size(); j++) {
        List<Double> leftCards = new ArrayList<>();
        leftCards.addAll(cards.subList(0, i));
        leftCards.addAll(cards.subList(i + 1, j));
        leftCards.addAll(cards.subList(j + 1, cards.size()));
        double a = cards.get(i), b = cards.get(j);

        leftCards.add(a + b);
        judgePoint24(leftCards);
        leftCards.removeLast();

        leftCards.add(a * b);
        judgePoint24(leftCards);
        leftCards.removeLast();

        leftCards.add(a - b);
        judgePoint24(leftCards);
        leftCards.removeLast();

        leftCards.add(b - a);
        judgePoint24(leftCards);
        leftCards.removeLast();

        if (b != 0) {
          leftCards.add(a / b);
          judgePoint24(leftCards);
          leftCards.removeLast();
        }

        if (a != 0) {
          leftCards.add(b / a);
          judgePoint24(leftCards);
          leftCards.removeLast();
        }
      }
    }
  }

  private static final double EPS = 1e-6;

  private boolean backtrack(double[] A, int n) {
    if (n == 1) return Math.abs(A[0] - 24) < EPS;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        double a = A[i], b = A[j];
        A[j] = A[n - 1];
        A[i] = a + b;
        if (backtrack(A, n - 1)) return true;
        A[i] = a - b;
        if (backtrack(A, n - 1)) return true;
        A[i] = b - a;
        if (backtrack(A, n - 1)) return true;
        A[i] = a * b;
        if (backtrack(A, n - 1)) return true;
        if (Math.abs(b) > EPS) {
          A[i] = a / b;
          if (backtrack(A, n - 1)) return true;
        }
        if (Math.abs(a) > EPS) {
          A[i] = b / a;
          if (backtrack(A, n - 1)) return true;
        }
        A[i] = a;
        A[j] = b;
      }
    }
    return false;
  }

  public boolean judgePoint24_1(int[] nums) {
    double[] A = new double[nums.length];
    for (int i = 0; i < nums.length; i++) A[i] = nums[i];
    return backtrack(A, A.length);
  }
}
