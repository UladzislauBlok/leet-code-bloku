package org.bloku.task._1912;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void tc1() {
    Solution.MovieRentingSystem uut =
        new Solution.MovieRentingSystem(
            3, new int[][] {{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}});

    assertThat(uut.search(1)).containsExactly(1, 0, 2);

    uut.rent(0, 1);
    uut.rent(1, 2);

    assertThat(uut.report()).containsExactly(List.of(0, 1), List.of(1, 2));

    uut.drop(1, 2);

    assertThat(uut.search(2)).containsExactly(0, 1);
  }
}
