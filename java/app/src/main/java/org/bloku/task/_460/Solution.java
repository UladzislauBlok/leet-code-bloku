package org.bloku.task._460;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("LFU Cache")
@Topics({DESIGN, HASH_TABLE, LINKED_LIST})
class Solution {

  static class LFUCache {
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, DoubleLinkedList> frequencies = new HashMap<>();
    private final int capacity;
    private int minFrequency;

    public LFUCache(int capacity) {
      // Defensive validation against edge cases
      this.capacity = capacity;
    }

    public int get(int key) {
      if (capacity <= 0) {
        return -1;
      }

      Node node = cache.get(key);
      if (node == null) {
        return -1;
      }
      updateFrequency(node);
      return node.value;
    }

    public void put(int key, int value) {
      if (capacity <= 0) {
        return;
      }

      Node node = cache.get(key);
      if (node == null) {
        if (cache.size() == capacity) {
          removeLFU();
        }
        node = new Node(key, value);
        // Replaced '__' with descriptive lambda parameter
        DoubleLinkedList levelOneList =
            frequencies.computeIfAbsent(1, freq -> new DoubleLinkedList());
        levelOneList.add(node);
        cache.put(key, node);
        minFrequency = 1;
      } else {
        updateFrequency(node);
        node.value = value;
      }
    }

    private void updateFrequency(Node node) {
      DoubleLinkedList currFrequencyList = frequencies.get(node.frequency);
      DoubleLinkedList nextFrequencyList =
          frequencies.computeIfAbsent(node.frequency + 1, freq -> new DoubleLinkedList());

      currFrequencyList.remove(node);
      nextFrequencyList.add(node);

      if (currFrequencyList.isEmpty()) {
        if (node.frequency == minFrequency) {
          minFrequency++;
        }
        frequencies.remove(node.frequency);
      }
      node.frequency++;
    }

    private void removeLFU() {
      DoubleLinkedList minFrequencyList = frequencies.get(minFrequency);
      if (minFrequencyList == null || minFrequencyList.isEmpty()) {
        return;
      }

      Node minFrequencyNode = minFrequencyList.head.next;
      minFrequencyList.remove(minFrequencyNode);

      if (minFrequencyList.isEmpty()) {
        frequencies.remove(minFrequency);
      }
      cache.remove(minFrequencyNode.key);
    }

    // Google Style Guide 4.8.7: ordered 'static final' instead of 'final static'
    private static final class Node {
      Node prev;
      Node next;
      int key;
      int value;
      int frequency;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
      }
    }

    private static final class DoubleLinkedList {
      final Node head;
      final Node tail;

      DoubleLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
      }

      void add(Node node) {
        // Renamed 'dummy' to 'tail' to align with its true identity
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
      }

      void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.prev = null;
        node.next = null;
      }

      boolean isEmpty() {
        return head.next == tail;
      }
    }
  }
}
