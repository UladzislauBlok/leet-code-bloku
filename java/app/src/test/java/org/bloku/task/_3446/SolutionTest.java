package org.bloku.task._3446;

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
  void solutionReturnsExpectedResult(int[][] grid, int[][] expected) {
    // given

    // when
    int[][] actual = solution.sortMatrix(grid);

    // then
    assertThat(actual).isDeepEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[][] {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}},
            new int[][] {{8, 2, 3}, {9, 6, 7}, {4, 5, 1}}),
        Arguments.of(new int[][] {{0, 1}, {1, 2}}, new int[][] {{2, 1}, {1, 0}}),
        Arguments.of(new int[][] {{1}}, new int[][] {{1}}));
  }
}
