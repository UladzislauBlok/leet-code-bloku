package org.bloku.task._3408;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("")
@Topics({DESIGN, HASH_TABLE, HEAP_PRIORITY_QUEUE})
class Solution {

  static class TaskManager {
    private static final Comparator<Task> COMPARATOR =
        (a, b) -> b.p - a.p == 0 ? b.tId - a.tId : b.p - a.p;

    private final int[] taskUser = new int[100001];
    private final Map<Integer, Integer> taskPriority = new HashMap<>();
    private final PriorityQueue<Task> tasks = new PriorityQueue<>(COMPARATOR);

    public TaskManager(List<List<Integer>> tasks) {
      Arrays.fill(taskUser, -1);
      for (List<Integer> task : tasks) {
        this.taskUser[task.get(1)] = task.get(0);
        this.taskPriority.put(task.get(1), task.get(2));
        this.tasks.add(new Task(task.get(1), task.get(2)));
      }
    }

    public void add(int userId, int taskId, int priority) {
      taskUser[taskId] = userId;
      taskPriority.put(taskId, priority);
      tasks.add(new Task(taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
      taskPriority.put(taskId, newPriority);
      tasks.add(new Task(taskId, newPriority));
    }

    public void rmv(int taskId) {
      taskUser[taskId] = -1;
      taskPriority.put(taskId, -1);
    }

    public int execTop() {
      while (!tasks.isEmpty() && taskPriority.get(tasks.peek().tId) != tasks.peek().p) tasks.poll();
      if (tasks.isEmpty()) return -1;
      Task task = tasks.poll();
      int res = taskUser[task.tId];
      taskUser[task.tId] = -1;
      taskPriority.put(task.tId, -1);
      return res;
    }

    private record Task(int tId, int p) {}
  }
}
