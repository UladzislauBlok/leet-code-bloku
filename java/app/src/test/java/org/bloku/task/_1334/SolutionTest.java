package org.bloku.task._1334;

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
  void solutionReturnsExpectedResult(int n, int[][] edges, int distanceThreshold, int expected) {
    // given

    // when
    int actual = solution.findTheCity(n, edges, distanceThreshold);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(4, new int[][] {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4, 3),
        Arguments.of(
            5,
            new int[][] {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}},
            2,
            0));
  }
}
