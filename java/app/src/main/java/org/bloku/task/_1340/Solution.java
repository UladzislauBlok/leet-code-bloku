package org.bloku.task._1340;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Jump Game V")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  public int maxJumps(int[] heights, int maxJumpDistance) {
    int totalElements = heights.length;
    int[] memoizationTable = new int[totalElements];
    int maxTotalJumps = 1;

    for (int i = 0; i < totalElements; i++) {
      maxTotalJumps =
          Math.max(maxTotalJumps, calculateMaxJumps(i, maxJumpDistance, heights, memoizationTable));
    }

    return maxTotalJumps;
  }

  /** Calculates the maximum jumps possible starting from a specific index. */
  private int calculateMaxJumps(
      int currentIndex, int maxJumpDistance, int[] heights, int[] memoizationTable) {
    if (memoizationTable[currentIndex] != 0) {
      return memoizationTable[currentIndex];
    }

    int bestJumpsFromHere = 1;

    // Explore valid jumps to the left
    for (int left = currentIndex - 1; left >= 0 && left >= currentIndex - maxJumpDistance; left--) {
      if (heights[left] >= heights[currentIndex]) {
        break; // Blocked by a taller or equal building
      }
      bestJumpsFromHere =
          Math.max(
              bestJumpsFromHere,
              calculateMaxJumps(left, maxJumpDistance, heights, memoizationTable) + 1);
    }

    // Explore valid jumps to the right
    for (int right = currentIndex + 1;
        right < heights.length && right <= currentIndex + maxJumpDistance;
        right++) {
      if (heights[right] >= heights[currentIndex]) {
        break; // Blocked by a taller or equal building
      }
      bestJumpsFromHere =
          Math.max(
              bestJumpsFromHere,
              calculateMaxJumps(right, maxJumpDistance, heights, memoizationTable) + 1);
    }

    memoizationTable[currentIndex] = bestJumpsFromHere;
    return bestJumpsFromHere;
  }
}
