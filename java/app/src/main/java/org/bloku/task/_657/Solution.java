package org.bloku.task._657;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Robot Return to Origin")
@Topics({STRING, SIMULATION})
class Solution {

  public boolean judgeCircle(String moves) {
    int x = 0, y = 0;
    for (char move : moves.toCharArray()) {
      if (move == 'U') y--;
      else if (move == 'D') y++;
      else if (move == 'L') x--;
      else if (move == 'R') x++;
    }
    return x == 0 && y == 0;
  }
}
