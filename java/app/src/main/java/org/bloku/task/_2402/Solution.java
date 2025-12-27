package org.bloku.task._2402;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.Arrays;
import java.util.PriorityQueue;

@LeetCodeName("Meeting Rooms III")
@Topics({ARRAY, HASH_TABLE, SORTING, HEAP_PRIORITY_QUEUE})
class Solution {

    // iterate O(n*m)
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n]; // Count of meetings per room
        long[] busy = new long[n]; // When each room becomes free

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long earliest = Long.MAX_VALUE;
            int roomIndex = -1;
            boolean assigned = false;

            for (int i = 0; i < n; i++) {
                if (busy[i] < earliest) {
                    earliest = busy[i];
                    roomIndex = i;
                }
                if (busy[i] <= start) {
                    busy[i] = end;
                    count[i]++;
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                busy[roomIndex] += (end - start);
                count[roomIndex]++;
            }
        }
        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }

    // Pq O(m*log n)
    public int mostBookedPq(int n, int[][] meetings) {
        int m = meetings.length;
        int[] map = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                (int)
                                        (a[1] - b[1] == 0
                                                ? a[0] - b[0]
                                                : a[1] - b[1])); // room num / end time
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) free.add(i);
        int i = 0;
        long time = meetings[0][0];
        while (i < m) {
            if (pq.isEmpty() || (pq.peek()[1] > meetings[i][0] && !free.isEmpty())) {
                long delay = time > meetings[i][0] ? time - meetings[i][0] : 0;
                int room = free.poll();
                pq.add(new long[] {room, delay + meetings[i][1]});
                map[room]++;
                i++;
            } else {
                long[] meet = pq.poll();
                time = meet[1];
                free.add((int) meet[0]);
            }
        }
        i = 0;
        int max = -1, res = 0;
        for (; i < n; i++) {
            if (map[i] > max) {
                max = map[i];
                res = i;
            }
        }
        return res;
    }

    /*
    1. Each meeting ... the lowest number -> lowest unused
    2. delayed meeting ... same duration -> keep original duration
    3. When a room ... earlier original start... -> fairness
    PriorityQueue and adjust time using lowest time at pq

    System.out.println("add " + time + " " + Arrays.toString(new int[]{room, delay + meetings[i][1]}));    */
}
