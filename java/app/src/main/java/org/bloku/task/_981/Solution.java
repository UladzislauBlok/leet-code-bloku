package org.bloku.task._981;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Time Based Key-Value Store")
@Topics({HASH_TABLE, DESIGN, RBT, BINARY_SEARCH})
class Solution {

  public static class TimeMap {

    private final Map<String, List<TimedValue>> store;

    public TimeMap() {
      this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      store.putIfAbsent(key, new ArrayList<>());
      store.get(key).add(new TimedValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
      if (!store.containsKey(key)) return "";
      List<TimedValue> values = store.get(key);
      if (timestamp > values.getLast().timestamp) return values.getLast().value;
      if (timestamp < values.getFirst().timestamp) return "";
      int left = 0, right = values.size() - 1;
      int mid = left + ((right - left) >> 1);
      while (left <= right) {
        TimedValue item = values.get(mid);
        if (item.timestamp == timestamp) return item.value;
        if (item.timestamp > timestamp) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        mid = left + ((right - left) >> 1);
      }
      return values.get(left - 1).value;
    }
  }

  private record TimedValue(int timestamp, String value) {}

  // RBT
  private static class TimeMapRBT {

    private final Map<String, TreeMap<Integer, String>> store;

    public TimeMapRBT() {
      this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      store.putIfAbsent(key, new TreeMap<>());
      store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
      if (!store.containsKey(key)) return "";
      TreeMap<Integer, String> timestampedStore = store.get(key);
      String res = timestampedStore.get(timestamp);
      if (res == null) {
        Map.Entry<Integer, String> e = timestampedStore.lowerEntry(timestamp);
        res = e != null ? e.getValue() : "";
      }
      return res;
    }
  }
}
