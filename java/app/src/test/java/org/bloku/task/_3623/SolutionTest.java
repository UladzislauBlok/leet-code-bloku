package org.bloku.task._3623;

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
    int actual = solution.countTrapezoids(points);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}}, 3),
        Arguments.of(
            new int[][] {
              {0, 0}, {2, 0}, {10, 1}, {20, 1}, {30, 1}, {40, 3}, {2, 3}, {3, 3}, {4, 3}, {5, 3}
            },
            43));
  }
}
