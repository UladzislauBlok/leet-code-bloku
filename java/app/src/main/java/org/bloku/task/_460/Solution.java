package org.bloku.task._460;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("LFU Cache")
@Topics({DESIGN, HASH_TABLE, LINKED_LIST})
class Solution {

  private static class LFUCache {

    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, DoubleLinkedList> frequencies = new HashMap<>();
    private final int capacity;
    private int minFrequency;

    public LFUCache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      if (capacity == 0) return -1;
      Node node = cache.get(key);
      if (node == null) {
        return -1;
      }
      updateFrequency(node);
      return node.value;
    }

    public void put(int key, int value) {
      if (capacity == 0) return;
      Node node = cache.get(key);
      if (node == null) {
        if (cache.size() == capacity) {
          removeLFU();
        }
        node = new Node(key, value);
        cache.put(key, node);
        insertNode(node);
        minFrequency = 1;
      } else {
        node.value = value;
        updateFrequency(node);
      }
    }

    private void insertNode(Node node) {
      DoubleLinkedList frequencyList =
          frequencies.computeIfAbsent(node.frequency, k -> new DoubleLinkedList());
      frequencyList.addRight(node);
    }

    private void removeLFU() {
      DoubleLinkedList frequencyList = frequencies.get(minFrequency);
      Node forRemoval = frequencyList.head.next;
      frequencyList.removeNode(forRemoval);
      if (frequencyList.isEmpty()) {
        frequencies.remove(minFrequency);
      }
      cache.remove(forRemoval.key);
    }

    private void updateFrequency(Node node) {
      int oldFreq = node.frequency;
      DoubleLinkedList oldList = frequencies.get(oldFreq);
      oldList.removeNode(node);
      if (oldList.isEmpty()) {
        frequencies.remove(oldFreq);
        if (oldFreq == minFrequency) {
          minFrequency++;
        }
      }

      node.frequency += 1;
      insertNode(node);
    }

    private static final class Node {
      private int key;
      private int value;
      private int frequency = 1;
      private Node prev;
      private Node next;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }

    private static final class DoubleLinkedList {
      private final Node head = new Node(-1, -1);
      private final Node tail = new Node(-1, -1);

      DoubleLinkedList() {
        head.next = tail;
        tail.prev = head;
      }

      void addRight(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
      }

      void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
      }

      boolean isEmpty() {
        return head.next == tail;
      }
    }
  }
}
