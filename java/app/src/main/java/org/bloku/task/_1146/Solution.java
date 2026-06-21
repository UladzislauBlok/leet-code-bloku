package org.bloku.task._1146;

import static org.bloku.util.Topic.*;

import java.util.TreeMap;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Snapshot Array")
@Topics({ARRAY, HASH_TABLE, BINARY_SEARCH, DESIGN, RBT})
class Solution {

  private final TreeMap<Integer, Integer>[] cache;

  private int epoch;

  Solution(int length) {
    // use precondition in prod code
    if (length <= 0) {
      throw new IllegalArgumentException("Length must be positive");
    }
    cache = new TreeMap[length];
    for (int i = 0; i < length; i++) {
      cache[i] = new TreeMap<Integer, Integer>();
      cache[i].put(0, 0);
    }
    epoch = 0;
  }

  public void set(int index, int val) {
    cache[index].put(epoch, val);
  }

  public int snap() {
    epoch++;
    return epoch - 1;
  }

  public int get(int index, int snapId) {
    return cache[index].floorEntry(snapId).getValue();
  }
}

/*
    brute force would be to copy entire array, but it's a liner time (for snap op) with high memory overhead
    I'm thinking about kind of databases / kernel IO design when there s flushing
    maybe we could aggregate all write in some queue / list and process in batches....
    what if we can do the same per write operation and just keep epoch number
    when reading we will need to find first or lower epoch to get the result, can be done easily with RBT (TreeMap)
*/
