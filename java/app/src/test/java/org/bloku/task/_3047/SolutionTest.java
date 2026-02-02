package org.bloku.task._3047;

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
  void solutionReturnsExpectedResult(int[][] bottomLeft, int[][] topRight, long expected) {
    // given

    // when
    long actual = solution.largestSquareArea(bottomLeft, topRight);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 1}, {2, 2}, {3, 1}}, new int[][] {{3, 3}, {4, 4}, {6, 6}}, 1),
        Arguments.of(
            new int[][] {{1, 1}, {1, 3}, {1, 5}}, new int[][] {{5, 5}, {5, 7}, {5, 9}}, 4));
  }
}
