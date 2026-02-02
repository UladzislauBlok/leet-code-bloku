package org.bloku.task._3027;

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
  void solutionReturnsExpectedResult(int[][] points, int expected) {
    // given

    // when
    int actual = solution.numberOfPairs(points);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 1}, {2, 2}, {3, 3}}, 0),
        Arguments.of(new int[][] {{6, 2}, {4, 4}, {2, 6}}, 2),
        Arguments.of(new int[][] {{3, 1}, {1, 3}, {1, 1}}, 2));
  }
}
