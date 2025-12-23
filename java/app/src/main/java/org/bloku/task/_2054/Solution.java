package org.bloku.task._2054;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

@LeetCodeName("Two Best Non-Overlapping Events")
@Topics({ARRAY, SORTING, HEAP_PRIORITY_QUEUE, RBT})
class Solution {

    public int maxTwoEvents(int[][] events) {
        int res = 0, max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) {
                max = Math.max(max, pq.poll()[2]);
            }
            res = Math.max(res, event[2] + max);
            pq.add(event);
        }
        return res;
    }

    public int maxTwoEventsRbt(int[][] events) {
        int max = 0;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> rbt = new TreeMap<>();
        for (int[] event : events) {
            max = Math.max(max, event[2]);
            rbt.put(event[1], max);
        }
        int res = 0;
        for (int[] event : events) {
            Map.Entry<Integer, Integer> entry = rbt.lowerEntry(event[0]);
            if (entry == null) continue;
            res = Math.max(res, event[2] + entry.getValue());
        }
        return Math.max(res, max);
    }

    /*
        greedy + sorting
    */
}
