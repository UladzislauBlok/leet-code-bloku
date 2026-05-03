package org.bloku.task._2833;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Furthest Point From Origin")
@Topics({STRING})
class Solution {

  public int furthestDistanceFromOrigin(String moves) {
    int R = 0, L = 0, empty = 0;
    for (char c : moves.toCharArray()) {
      switch (c) {
        case 'R' -> R++;
        case 'L' -> L++;
        default -> empty++;
      }
    }
    return Math.abs(R - L) + empty;
  }
}
