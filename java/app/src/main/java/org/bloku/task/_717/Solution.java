package org.bloku.task._717;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("1-bit and 2-bit Characters")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  // we need to went through bits with the rule
  // that bit 1 takes any char after
  // check if last char is free
  public boolean isOneBitCharacter(int[] bits) {
    int n = bits.length;
    boolean free = true;
    for (int i = 0; i < n - 1; i++) {
      if (bits[i] == 0) free = true;
      else free = !free;
    }
    return free;
  }
}
