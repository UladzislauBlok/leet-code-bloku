package org.bloku.task._2463;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Total Distance Traveled")
@Topics({SORTING, ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  private long[][] memo;
  private List<Integer> robots;
  private List<Integer> factories;

  public long minimumTotalDistance_(List<Integer> robot, int[][] factory) {
    this.robots = robot;
    this.factories = new ArrayList<>();
    Collections.sort(robot);
    Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 0; i < factory.length; i++) {
      for (int j = 0; j < factory[i][1]; j++) {
        factories.add(factory[i][0]);
      }
    }
    this.memo = new long[robots.size()][factories.size()];
    for (long[] row : memo) Arrays.fill(row, -1);
    return dp(0, 0);
  }

  private long dp(int robot, int factory) {
    if (robot == robots.size()) return 0;
    if (factory == factories.size()) return (long) 1e12;
    if (memo[robot][factory] != -1) return memo[robot][factory];
    long best = Math.abs(robots.get(robot) - factories.get(factory)) + dp(robot + 1, factory + 1);
    best = Math.min(best, dp(robot, factory + 1));
    memo[robot][factory] = best;
    return best;
  }

  public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
    Collections.sort(robot);
    Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
    List<Integer> factoryPositions = new ArrayList<>();
    for (int[] f : factory) {
      for (int i = 0; i < f[1]; i++) {
        factoryPositions.add(f[0]);
      }
    }
    int robotCount = robot.size();
    int factoryCount = factoryPositions.size();
    long[][] dp = new long[robotCount + 1][factoryCount + 1];
    for (int i = 0; i < robotCount; i++) {
      dp[i][factoryCount] = (long) 1e12;
    }
    for (int i = robotCount - 1; i >= 0; i--) {
      for (int j = factoryCount - 1; j >= 0; j--) {
        long assign = Math.abs(robot.get(i) - factoryPositions.get(j)) + dp[i + 1][j + 1];
        long skip = dp[i][j + 1];
        dp[i][j] = Math.min(assign, skip);
      }
    }
    return dp[0][0];
  }

  /*
      we can move every robot either left or right,
      so there is overlapping property
      this can bring me to dp solution
      how to effectively search for next anb previous factory?
      well it shouldn't be effective: 1 <= robot.length, factory.length <= 100

      do we need to be greedy when choosing factory? we can be greedy

      F1------F2-----R1-----R2
      1--------5-----10-----13

      10 - 5 + 13 - 1 = 17;
      10 - 1 + 13 - 5 = 17;
  */
}
