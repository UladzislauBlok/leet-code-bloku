package org.bloku.task._3508;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SequencedSet;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Implement Router")
@Topics({DESIGN, HASH_TABLE, BINARY_SEARCH, ORDERED_SET})
class Solution {

  static class Router {

    private final SequencedSet<Packet> set = new LinkedHashSet<>();
    private final Map<Integer, List<Integer>> map = new HashMap<>();
    private final Map<Integer, Integer> mapRemoved = new HashMap<>();
    private final int memoryLimit;

    public Router(int memoryLimit) {
      this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int s, int d, int t) {
      Packet p = new Packet(s, d, t);
      if (set.contains(p)) return false;
      if (set.size() == memoryLimit) {
        Packet old = set.removeFirst();
        mapRemoved.merge(old.d, 1, Integer::sum);
      }
      set.add(p);
      map.putIfAbsent(d, new ArrayList<>());
      map.get(d).add(t);
      return true;
    }

    public int[] forwardPacket() {
      if (set.isEmpty()) return new int[] {};
      Packet old = set.removeFirst();
      mapRemoved.merge(old.d, 1, Integer::sum);
      return new int[] {old.s, old.d, old.t};
    }

    public int getCount(int d, int start, int end) {
      if (!map.containsKey(d)) return 0;
      int lowerBound = mapRemoved.getOrDefault(d, 0);
      List<Integer> tmps = map.get(d);
      return up(tmps, lowerBound, end) - low(tmps, lowerBound, start);
    }

    private int low(List<Integer> tmps, int left, int target) {
      int right = tmps.size();
      while (left < right) {
        int mid = (right + left) >> 1;
        if (tmps.get(mid) >= target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return left;
    }

    private int up(List<Integer> tmps, int left, int target) {
      int right = tmps.size();
      while (left < right) {
        int mid = (right + left) >> 1;
        if (tmps.get(mid) > target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return left;
    }

    private record Packet(int s, int d, int t) {}
  }

  static class Router_1 {
    private final Deque<int[]> que;
    private final HashMap<Integer, List<int[]>> map;
    private final int size;

    public Router_1(int memoryLimit) {
      que = new LinkedList<>();
      map = new HashMap<>();
      this.size = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
      if (!map.containsKey(destination)) {
        map.put(destination, new ArrayList<>());
      }
      List<int[]> list = map.get(destination);
      int left = small(list, timestamp);

      if (list.size() != 0) {
        for (int i = left; i < list.size() && list.get(i)[1] == timestamp; i++) {
          if (list.get(i)[0] == source) return false;
        }
      }
      map.get(destination).add(new int[] {source, timestamp});
      que.addLast(new int[] {source, destination, timestamp});
      if (que.size() > size) {
        forwardPacket();
      }

      return true;
    }

    public int[] forwardPacket() {
      if (que.size() == 0) return new int[0];
      int[] arr = que.pollFirst();
      map.get(arr[1]).removeFirst();
      return arr;
    }

    public int getCount(int destination, int startTime, int endTime) {
      if (!map.containsKey(destination)) {
        return 0;
      }
      List<int[]> list = map.get(destination);
      int left = small(list, startTime);
      int right = big(list, endTime);
      if (left > right) return 0;
      return right - left + 1;
    }

    public int small(List<int[]> list, int start) {
      int left = 0;
      int right = list.size() - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (list.get(mid)[1] >= start) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      return left;
    }

    public int big(List<int[]> list, int end) {
      int left = 0;
      int right = list.size() - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (list.get(mid)[1] > end) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      return right;
    }
  }
}
