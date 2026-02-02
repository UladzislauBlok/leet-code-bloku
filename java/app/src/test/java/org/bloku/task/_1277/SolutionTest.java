package org.bloku.task._1277;

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
  void solutionReturnsExpectedResult(int[][] matrix, int expected) {
    // given

    // when
    int actual = solution.countSquares(matrix);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}, 15),
        Arguments.of(new int[][] {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}, 7),
        Arguments.of(new int[][] {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}, 32),
        Arguments.of(new int[][] {{1, 1, 1, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}, 18));
  }
}
