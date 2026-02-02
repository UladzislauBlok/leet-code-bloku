package org.bloku.task._225;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.Deque;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Implement Stack using Queues")
@Topics({DESIGN, STACK, QUEUE})
class Solution {

  static class MyStack {

    private final Deque<Integer> queue = new ArrayDeque<>();
    private final Deque<Integer> stack = new ArrayDeque<>();

    public MyStack() {}

    public void push(int x) {
      stack.add(x);
    }

    public int pop() {
      if (stack.isEmpty() || stack.size() > 1) move();
      if (stack.isEmpty()) return -1;
      return stack.poll();
    }

    public int top() {
      if (stack.isEmpty() || stack.size() > 1) move();
      if (stack.isEmpty()) return -1;
      return stack.peek();
    }

    public boolean empty() {
      return queue.isEmpty() && stack.isEmpty();
    }

    private void move() {
      while (!stack.isEmpty()) queue.add(stack.poll());
      while (!queue.isEmpty()) stack.add(queue.poll());
      while (stack.size() > 1) queue.add(stack.poll());
    }
  }
}
