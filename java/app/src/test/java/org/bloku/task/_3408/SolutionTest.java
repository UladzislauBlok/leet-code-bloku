package org.bloku.task._3408;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void tc1() {
    List<List<Integer>> tasks =
        List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15));
    Solution.TaskManager uut = new Solution.TaskManager(tasks);

    uut.add(4, 104, 5);

    uut.edit(102, 8);

    assertThat(uut.execTop()).isEqualTo(3);

    uut.rmv(101);

    uut.add(5, 105, 15);

    assertThat(uut.execTop()).isEqualTo(5);
  }
}
