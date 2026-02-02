package org.bloku.task._1504;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Deque;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Submatrices With All Ones")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, STACK, MATRIX})
class Solution {

  // Key here is mix of 84 and 2348
  public int numSubmat(int[][] mat) {
    int res = 0, m = mat.length, n = mat[0].length;
    int[] histogram = new int[n];
    Deque<int[]> stack = new ArrayDeque<>();
    for (int[] row : mat) {
      stack.push(new int[] {-1, 0, -1}); // (idx, val, height)
      for (int i = 0; i < n; i++) {
        int h = histogram[i] = row[i] == 1 ? ++histogram[i] : 0;
        while (!stack.isEmpty() && stack.peek()[2] >= h) // find first less on left
        stack.pop();
        int[] last = stack.peek(); // peek to never remove base case (left boundry)
        int curr = last[1] + (i - last[0]) * h; // right (border - left) * h. comment below*
        stack.push(new int[] {i, curr, h});
        res += curr;
      }
    }
    return res;
  }

  // Comment from line 15*
  // we have to keep tack of prev count for case when:
  /*

  0   0   0   0   0
  0   0   0   1   1
  0   0   0   1   1
  1   1   Z   1   X
  1   1   1   1   1

  when we in point X we need to check 2 * 5 + count from point Z as it part of X
  */

}
