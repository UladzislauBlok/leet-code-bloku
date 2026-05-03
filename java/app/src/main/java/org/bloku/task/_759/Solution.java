package org.bloku.task._759;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Employee Free Time")
@Topics({SORTING, INTERVALS})
class Solution {

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> flatten = new ArrayList<>();
    for (List<Interval> employee : schedule) flatten.addAll(employee);
    Collections.sort(flatten, (a, b) -> a.start - b.start);
    List<Interval> result = new ArrayList<>();
    int end = flatten.getFirst().end;
    for (Interval interval : flatten) {
      if (end < interval.start) result.add(new Interval(end, interval.start));
      end = Math.max(end, interval.end);
    }
    return result;
  }

  private record Interval(int start, int end) {}
}
