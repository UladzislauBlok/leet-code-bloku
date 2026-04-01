package org.bloku.task._2751;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Robot Collisions\n")
@Topics({SORTING, STACK})
class Solution {

  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    List<Robot> live = new ArrayList<>();
    Deque<Robot> stack = new ArrayDeque<>();
    int n = positions.length;
    Robot[] robots = new Robot[n];
    for (int i = 0; i < n; i++) {
      robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
    }
    Arrays.sort(robots, (a, b) -> a.pos - b.pos);
    for (Robot robot : robots) {
      if (robot.dir == 'R') {
        stack.push(robot);
      } else {
        boolean robotAlive = true;
        while (robotAlive && !stack.isEmpty()) {
          Robot leftRobot = stack.peek();
          if (leftRobot.health > robot.health) {
            leftRobot.health--;
            robotAlive = false;
          } else if (leftRobot.health < robot.health) {
            stack.pop();
            robot.health--;
          } else {
            stack.pop();
            robotAlive = false;
          }
        }
        if (robotAlive) live.add(robot);
      }
    }
    live.addAll(stack);
    List<Integer> result = new ArrayList<>();
    live.sort((a, b) -> a.origPos - b.origPos);
    for (Robot robot : live) {
      result.add(robot.health);
    }
    return result;
  }

  private static class Robot {
    private int pos;
    private int health;
    private char dir;
    private int origPos;

    Robot(int pos, int health, char dir, int origPos) {
      this.pos = pos;
      this.health = health;
      this.dir = dir;
      this.origPos = origPos;
    }
  }

  // not mine, but interesting one
  public List<Integer> survivedRobotsHealths_(int[] positions, int[] h, String directions) {
    int n = positions.length;
    List<Integer> ind = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ind.add(i);
    }
    ind.sort((a, b) -> Integer.compare(positions[a], positions[b]));

    Deque<Integer> stack = new ArrayDeque<>();
    for (int i : ind) {
      if (directions.charAt(i) == 'R') {
        stack.push(i);
        continue;
      }
      while (!stack.isEmpty() && h[i] > 0) {
        if (h[stack.peek()] < h[i]) {
          h[stack.pop()] = 0;
          h[i] -= 1;
        } else if (h[stack.peek()] > h[i]) {
          h[stack.peek()] -= 1;
          h[i] = 0;
        } else {
          h[stack.pop()] = 0;
          h[i] = 0;
        }
      }
    }

    List<Integer> res = new ArrayList<>();
    for (int v : h) {
      if (v > 0) {
        res.add(v);
      }
    }
    return res;
  }
}
