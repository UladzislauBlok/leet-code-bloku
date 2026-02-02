package org.bloku.task._3217;

import static org.bloku.util.Topic.*;

import org.bloku.domain.ListNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Delete Nodes From Linked List Present in Array")
@Topics({LINKED_LIST, HASH_TABLE})
class Solution {

  public ListNode modifiedListModified(int[] nums, ListNode head) {
    boolean[] set = new boolean[100001];
    for (int num : nums) set[num] = true;
    ListNode res = head;
    while (res.next != null && set[res.val]) res = res.next;
    ListNode prev = res;
    ListNode curr = res.next;
    while (curr != null) {
      if (set[curr.val]) {
        prev.next = curr.next;
      } else {
        prev = prev.next;
      }
      curr = curr.next;
    }
    return res;
  }

  public ListNode modifiedList(int[] nums, ListNode head) {
    boolean[] set = new boolean[100001];
    for (int num : nums) set[num] = true;
    ListNode temp = new ListNode();
    ListNode current = temp;
    while (head != null) {
      if (!set[head.val]) {
        current.next = head;
        current = current.next;
      }
      head = head.next;
    }
    current.next = null;
    return temp.next;
  }
}
