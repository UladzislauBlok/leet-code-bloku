package org.bloku.task._2069;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Walking Robot Simulation II")
@Topics({DESIGN, SIMULATION})
class Solution {

  class Robot {

    private final int width;
    private final int height;
    private final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final int[] pos;
    private int dirIdx;

    public Robot(int width, int height) {
      this.width = width;
      this.height = height;
      this.pos = new int[] {0, 0};
      this.dirIdx = 1;
    }

    public void step(int num) {
      num %= ((width + height - 2) * 2);
      num += (width + height - 2) * 2;
      for (int i = 0; i < num; i++) {
        pos[0] += directions[dirIdx][0];
        pos[1] += directions[dirIdx][1];
        if (pos[0] < 0 || pos[0] == width || pos[1] < 0 || pos[1] == height) {
          pos[0] -= directions[dirIdx][0];
          pos[1] -= directions[dirIdx][1];
          dirIdx = (dirIdx - 1 + 4) % 4;
          i--;
        }
      }
    }

    public int[] getPos() {
      return pos;
    }

    public String getDir() {
      return switch (dirIdx) {
        case 0 -> "North";
        case 1 -> "East";
        case 2 -> "South";
        case 3 -> "West";
        default -> throw new RuntimeException();
      };
    }
  }
}
