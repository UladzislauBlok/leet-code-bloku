package org.bloku.task._1504;

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
    int actual = solution.numSubmat(matrix);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}, 13),
        Arguments.of(new int[][] {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}}, 24));
  }
}
