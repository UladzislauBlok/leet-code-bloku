package org.bloku.task._3464;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximize the Distance Between Points on a Square")
@Topics({MATH, BINARY_SEARCH, GEOMETRY, SORTING})
class Solution {

  public int maxDistance(int side, int[][] points, int k) {
    List<Long> arr = new ArrayList<>();

    for (int[] p : points) {
      int x = p[0];
      int y = p[1];
      if (x == 0) {
        arr.add((long) y);
      } else if (y == side) {
        arr.add((long) side + x);
      } else if (x == side) {
        arr.add(side * 3L - y);
      } else {
        arr.add(side * 4L - x);
      }
    }
    Collections.sort(arr);

    long lo = 1;
    long hi = side;
    int ans = 0;

    while (lo <= hi) {
      long mid = (lo + hi) / 2;
      if (check(arr, side, k, mid)) {
        lo = mid + 1;
        ans = (int) mid;
      } else {
        hi = mid - 1;
      }
    }
    return ans;
  }

  private boolean check(List<Long> arr, int side, int k, long limit) {
    long perimeter = side * 4L;

    for (long start : arr) {
      long end = start + perimeter - limit; // offset from start if check counterclockwise
      long cur = start;

      for (int i = 0; i < k - 1; i++) {
        int idx = lowerBound(arr, cur + limit);
        if (idx == arr.size() || arr.get(idx) > end) {
          cur = -1;
          break;
        }
        cur = arr.get(idx);
      }

      if (cur >= 0) {
        return true;
      }
    }
    return false;
  }

  private int lowerBound(List<Long> arr, long target) {
    int left = 0;
    int right = arr.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
    /*
        When we increase min distance we decrease number of points we can use

        k = 4

        8p      6p              4p          2p
        -------------------------------------->
        distance

        Our task is to find distance where we'll firstly find k points (4 in current example)
        We can do that using binary search between 1 and side * 2
        How to effectivelly find all points within selected distance?
        it's kinda dp or backtracking, we can include any point or ignore it
        ...
        btw if we fall back to dp.... may be it's just dp
        I will include or not include every point
        If I reach out end with less than k points selected return INF
        How to memorize things? That's hard becasue I need to know mutable state (which typicaly breaks dp)
        ...
        back to binary search... how to find min distance.... I need to select k elements from points...
        may be make it simple and just bracktrack it... too slow

    */
