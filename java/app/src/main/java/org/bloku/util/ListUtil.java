package org.bloku.util;

import java.util.List;
import org.bloku.domain.ListNode;

public class ListUtil {

  public static ListNode buildListNode(List<Integer> nodeValues) {
    ListNode head = new ListNode(nodeValues.getFirst());
    ListNode curr = head;
    for (int i = 1; i < nodeValues.size(); i++) {
      curr.next = new ListNode(nodeValues.get(i));
      curr = curr.next;
    }
    return head;
  }
}
