package org.bloku.task._3885;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Design Event Manager")
@Topics({DESIGN, HEAP_PRIORITY_QUEUE, HASH_TABLE})
class Solution {

  class EventManager {

    private final PriorityQueue<Event> pq =
        new PriorityQueue<>((a, b) -> a.prio == b.prio ? a.id - b.id : b.prio - a.prio);
    private final Map<Integer, Integer> map = new HashMap<>();

    public EventManager(int[][] events) {
      for (int[] event : events) {
        pq.add(new Event(event[0], event[1]));
        map.put(event[0], event[1]);
      }
    }

    public void updatePriority(int eventId, int newPriority) {
      pq.add(new Event(eventId, newPriority));
      map.put(eventId, newPriority);
    }

    public int pollHighest() {
      cleanUp();
      if (pq.isEmpty()) return -1;
      map.put(pq.peek().id, -1);
      return pq.poll().id;
    }

    private void cleanUp() {
      while (!pq.isEmpty() && pq.peek().prio != map.get(pq.peek().id)) pq.poll();
    }

    private record Event(int id, int prio) {}
  }
}
