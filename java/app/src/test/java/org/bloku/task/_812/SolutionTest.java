package org.bloku.task._812;

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
  void solutionReturnsExpectedResult(int[][] points, double expected) {
    // given

    // when
    double actual = solution.largestTriangleArea(points);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {35, -23}, {-12, -48}, {-34, -40}, {21, -25}, {-35, -44}, {24, 1},
              {16, -9}, {41, 4}, {-36, -49}, {42, -49}, {-37, -20}, {-35, 11},
              {-2, -36}, {18, 21}, {18, 8}, {-24, 14}, {-23, -11}, {-8, 44},
              {-19, -3}, {0, -10}, {-21, -4}, {23, 18}
            },
            3627.00000),
        Arguments.of(new int[][] {{0, 0}, {1, 1}, {2, 2}}, 0.0));
  }
}
