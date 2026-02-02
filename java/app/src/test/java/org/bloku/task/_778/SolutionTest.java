package org.bloku.task._778;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() {
    this.solution = new Solution();
  }

  @ParameterizedTest
  @MethodSource
  void solutionReturnsExpectedResult(int[][] grid, int expected) {
    // given

    // when
    int actual = solution.swimInWater(grid);
    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{0, 2}, {1, 3}}, 3),
        Arguments.of(
            new int[][] {
              {0, 1, 2, 3, 4},
              {24, 23, 22, 21, 5},
              {12, 13, 14, 15, 16},
              {11, 17, 18, 19, 20},
              {10, 9, 8, 7, 6}
            },
            16));
  }
}
