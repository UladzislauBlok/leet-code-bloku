package org.bloku.task._3510;

import static org.bloku.util.Topic.*;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Pair Removal to Sort Array II")
@Topics({ARRAY, HEAP_PRIORITY_QUEUE, HASH_TABLE, ORDERED_SET, RBT, LINKED_LIST, SIMULATION})
class Solution {
  public int minimumPairRemoval(int[] nums) {
    TreeMap<Integer, Long> map = new TreeMap<>(); // pos - num
    PriorityQueue<Tuple> pq = new PriorityQueue<>();
    int res = 0, n = nums.length, decreasing = 0;
    map.put(0, 1L * nums[0]);
    for (int i = 1; i < n; i++) {
      long num1 = 1L * nums[i - 1];
      long num2 = 1L * nums[i];
      if (num2 < num1) decreasing++;
      map.put(i, num2);
      pq.add(new Tuple(i - 1, num1, i, num2, num1 + num2));
    }
    while (decreasing > 0) {
      Tuple t = pq.poll();
      Long n1 = map.get(t.pos1);
      Long n2 = map.get(t.pos2);
      if (n1 == null || n1 != t.num1 || n2 == null || n2 != t.num2) continue;
      Map.Entry<Integer, Long> prev = map.lowerEntry(t.pos1);
      Map.Entry<Integer, Long> next = map.higherEntry(t.pos2);
      boolean needFix1 = false;
      if (prev != null && prev.getValue() > t.num1) needFix1 = true;
      boolean needFix2 = false;
      if (next != null && next.getValue() < t.num2) needFix2 = true;
      map.remove(t.pos2);
      map.put(t.pos1, t.sum);
      boolean fix1 = false;
      boolean fix2 = false;
      if (prev != null)
        pq.add(new Tuple(prev.getKey(), prev.getValue(), t.pos1, t.sum, prev.getValue() + t.sum));
      if (next != null)
        pq.add(new Tuple(t.pos1, t.sum, next.getKey(), next.getValue(), next.getValue() + t.sum));
      if (prev != null && prev.getValue() > t.num1) needFix1 = true;
      if (needFix1 && prev.getValue() <= t.sum) fix1 = true;
      if (needFix2 && next.getValue() >= t.sum) fix2 = true;
      if (fix1) decreasing--;
      if (fix2) decreasing--;
      if (t.num1 > t.num2) decreasing--;
      if (prev != null && !needFix1 && prev.getValue() > t.sum) decreasing++;
      if (next != null && !needFix2 && next.getValue() < t.sum) decreasing++;
      res++;
    }
    return res;
  }

  private record Tuple(int pos1, long num1, int pos2, long num2, long sum)
      implements Comparable<Tuple> {

    public int compareTo(Tuple o) {
      int res = Long.compare(this.sum, o.sum);
      return res != 0 ? res : this.pos1 - o.pos1;
    }
  }

  // from leetcode using linked list, which is better here than rbt
  public int minimumPairRemoval_(int[] nums) {
    PriorityQueue<PQItem> pq = new PriorityQueue<>();
    boolean[] merged = new boolean[nums.length]; // lazy deletion, nice one

    int decreaseCount = 0;
    int count = 0;
    Node head = new Node(nums[0], 0);
    Node current = head;

    for (int i = 1; i < nums.length; i++) {
      Node newNode = new Node(nums[i], i);
      current.next = newNode;
      newNode.prev = current;
      pq.offer(new PQItem(current, newNode, current.value + newNode.value));
      if (nums[i - 1] > nums[i]) {
        decreaseCount++;
      }
      current = newNode;
    }

    while (decreaseCount > 0) {
      PQItem item = pq.poll();
      Node first = item.first;
      Node second = item.second;
      long cost = item.cost;

      if (merged[first.left] || merged[second.left] || first.value + second.value != cost) {
        continue;
      }
      count++;
      if (first.value > second.value) {
        decreaseCount--;
      }

      Node prevNode = first.prev;
      Node nextNode = second.next;
      first.next = nextNode;
      if (nextNode != null) {
        nextNode.prev = first;
      }

      if (prevNode != null) {
        if (prevNode.value > first.value && prevNode.value <= cost) {
          decreaseCount--;
        } else if (prevNode.value <= first.value && prevNode.value > cost) {
          decreaseCount++;
        }

        pq.offer(new PQItem(prevNode, first, prevNode.value + cost));
      }

      if (nextNode != null) {
        if (second.value > nextNode.value && cost <= nextNode.value) {
          decreaseCount--;
        } else if (second.value <= nextNode.value && cost > nextNode.value) {
          decreaseCount++;
        }

        pq.offer(new PQItem(first, nextNode, cost + nextNode.value));
      }

      first.value = cost;
      merged[second.left] = true;
    }

    return count;
  }

  private static class Node {

    long value;
    int left; // why left, this should be pos
    Node prev;
    Node next;

    Node(int value, int left) {
      this.value = value;
      this.left = left;
    }
  }

  private static class PQItem implements Comparable<PQItem> {

    Node first;
    Node second;
    long cost;

    PQItem(Node first, Node second, long cost) {
      this.first = first;
      this.second = second;
      this.cost = cost;
    }

    @Override
    public int compareTo(PQItem other) {
      if (this.cost == other.cost) {
        return this.first.left - other.first.left;
      }
      return this.cost < other.cost ? -1 : 1;
    }
  }
  /*
      1 <= nums.length <= 10^5
      we're going through nums,
      until we find first decreasing pair, we're find
      when we find it we need to start operations
      while going through nums we can keep all sums using pq
      and then take min, but problem is that when we 'merge' two elems
      we invalidate two pairs nit just one. e.g.,:
      [1,2,3]
      pq: [1,2] ; [2,3]
      when we sum [1,2], we need to invalidate [2,3]
      can we use hashMap for this purpose - UPD: we can't use hashmap. I used RBT, but linked list is better for this case
      ...
      wrong as min sum could be at the end, e.g.,:
      5,  2,  [3,  1] -> this is expected pair
          ^
      we'll trigger here
      what if we just put everything into pq, and when merging two numbers
      we'll check if we've fixed decreasing
  */
}
