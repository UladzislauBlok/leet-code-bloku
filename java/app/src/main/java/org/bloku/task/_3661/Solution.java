package org.bloku.task._3661;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Walls Destroyed by Robots")
@Topics({DYNAMIC_PROGRAMMING, BINARY_SEARCH, SORTING})
class Solution {

  private Map<Long, Integer> memo;
  private Robot[] robots;
  private int[] walls;

  public int maxWalls(int[] robots, int[] distance, int[] walls) {
    int n = robots.length;
    this.robots = new Robot[n];
    for (int i = 0; i < n; i++) {
      this.robots[i] = new Robot(robots[i], distance[i]);
    }
    Arrays.sort(this.robots, (a, b) -> a.position - b.position);
    this.walls = walls;
    Arrays.sort(this.walls);
    this.memo = new HashMap<>();
    return dp(0, 0);
  }

  private int dp(int idx, int left) {
    if (idx == robots.length) return 0;
    long key = idx * 10000000L + left;
    if (memo.get(key) != null) return memo.get(key);
    Robot robot = robots[idx];
    int[] leftWalls = findWalls(left, robot.position, robot.position - robot.distance);
    int best = leftWalls[0] + dp(idx + 1, leftWalls[1]);
    int right =
        Math.min(
            robot.position + robot.distance,
            (idx < robots.length - 1 ? robots[idx + 1].position - 1 : Integer.MAX_VALUE));
    int[] rightWalls = findWalls(leftWalls[1] - 1, right, robot.position);
    best = Math.max(best, rightWalls[0] + dp(idx + 1, rightWalls[1]));
    memo.put(key, best);
    return best;
  }

  private int[] findWalls(int wallIdx, int right, int start) {
    if (wallIdx < 0) wallIdx++;
    int[] res = new int[] {0, 0};
    int n = walls.length;
    while (wallIdx < n && walls[wallIdx] <= right) {
      if (walls[wallIdx++] >= start) res[0]++;
    }
    res[1] = wallIdx;
    return res;
  }

  private record Robot(int position, int distance) {}

  /*
      I see some overlying here: every robot can shoot either left or right
      but constrains are quite big
      may be it's greedy in some way, but I don't see how to make it greedy when we have two chooses
  */
}
