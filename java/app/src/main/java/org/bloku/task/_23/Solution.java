package org.bloku.task._23;

import static org.bloku.util.Topic.*;

import java.util.PriorityQueue;
import org.bloku.domain.ListNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Merge k Sorted Lists")
@Topics({LINKED_LIST, HEAP_PRIORITY_QUEUE})
class Solution {

  public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (int i = 0; i < n; i++) {
      if (lists[i] == null) continue;
      pq.add(lists[i]);
    }
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      curr.next = node;
      curr = curr.next;
      if (curr.next != null) pq.add(curr.next);
      curr.next = null;
    }
    return dummy.next;
  }
}
