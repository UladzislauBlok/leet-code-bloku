package org.bloku.task._232;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Deque;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Implement Queue using Stacks")
@Topics({DESIGN, STACK, QUEUE})
class Solution {

  static class MyQueue {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> queue = new ArrayDeque<>();

    public MyQueue() {}

    public void push(int x) {
      stack.push(x);
    }

    public int pop() {
      if (queue.isEmpty()) move();
      if (queue.isEmpty()) return -1;
      return queue.pop();
    }

    public int peek() {
      if (queue.isEmpty()) move();
      if (queue.isEmpty()) return -1;
      return queue.peek();
    }

    public boolean empty() {
      return stack.isEmpty() && queue.isEmpty();
    }

    private void move() {
      while (!stack.isEmpty()) queue.push(stack.pop());
    }
  }
}
