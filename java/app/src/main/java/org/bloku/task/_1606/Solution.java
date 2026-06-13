package org.bloku.task._1606;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Servers That Handled Most Number of Requests")
@Topics({HEAP_PRIORITY_QUEUE, RBT})
class Solution {

  private record ServerTask(long freeTime, int serverId) {}

  public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
    if (arrival == null || load == null || arrival.length != load.length || k <= 0) {
      throw new IllegalArgumentException("Invalid input dimensions or server count.");
    }
    int[] requestCounts = new int[k];
    TreeSet<Integer> availableServers = new TreeSet<>();
    PriorityQueue<ServerTask> busyServers =
        new PriorityQueue<>(Comparator.comparingLong(ServerTask::freeTime));
    for (int i = 0; i < k; i++) {
      availableServers.add(i);
    }
    for (int i = 0; i < arrival.length; i++) {
      long start = arrival[i];
      long end = start + load[i];
      while (!busyServers.isEmpty() && busyServers.peek().freeTime() <= start) {
        availableServers.add(busyServers.poll().serverId());
      }
      if (availableServers.isEmpty()) {
        continue;
      }
      Integer preferredHandler = availableServers.ceiling(i % k);
      if (preferredHandler == null) {
        preferredHandler = availableServers.getFirst();
      }
      requestCounts[preferredHandler]++;
      busyServers.add(new ServerTask(end, preferredHandler));
      availableServers.remove(preferredHandler);
    }
    return findMaxProcessedServers(requestCounts, k);
  }

  private static List<Integer> findMaxProcessedServers(int[] requestCounts, int k) {
    int maxRequests = 0;
    for (int count : requestCounts) {
      maxRequests = Math.max(maxRequests, count);
    }
    List<Integer> busiestServersList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      if (requestCounts[i] == maxRequests) {
        busiestServersList.add(i);
      }
    }
    return busiestServersList;
  }
}
