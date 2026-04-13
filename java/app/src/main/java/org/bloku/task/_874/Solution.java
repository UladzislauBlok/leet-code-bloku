package org.bloku.task._874;

import static org.bloku.util.Topic.*;

import java.util.HashSet;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Walking Robot Simulation")
@Topics({ARRAY, HASH_TABLE, SIMULATION})
class Solution {

  public int robotSim(int[] commands, int[][] obstacles) {
    Set<Integer> set = new HashSet<>();
    for (int[] obstacle : obstacles) {
      set.add(obstacle[0] * 100000 + obstacle[1]);
    }
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dirIdx = 0;
    int[] pos = new int[] {0, 0};
    int max = 0;
    for (int command : commands) {
      if (command == -2) {
        dirIdx--;
        dirIdx = (dirIdx + 4) % 4;
      } else if (command == -1) {
        dirIdx++;
        dirIdx %= 4;
      } else {
        for (int i = 0; i < command; i++) {
          int x = pos[0] + directions[dirIdx][0];
          int y = pos[1] + directions[dirIdx][1];
          int key = x * 100000 + y;
          if (set.contains(key)) break;
          pos[0] = x;
          pos[1] = y;
        }
        max = Math.max(max, pos[0] * pos[0] + pos[1] * pos[1]);
      }
    }
    return max;
  }
}
