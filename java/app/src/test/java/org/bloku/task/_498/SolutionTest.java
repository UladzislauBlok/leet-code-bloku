package org.bloku.task._498;

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
  void solutionReturnsExpectedResult(int[][] mat, int[] expected) {
    // given

    // when
    int[] actual = solution.findDiagonalOrder(mat);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[] {1, 2, 4, 7, 5, 3, 6, 8, 9}),
        Arguments.of(new int[][] {{1, 2}, {3, 4}}, new int[] {1, 2, 3, 4}));
  }
}
