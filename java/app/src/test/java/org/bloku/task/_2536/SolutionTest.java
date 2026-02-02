package org.bloku.task._2536;

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
  void solutionReturnsExpectedResult(int n, int[][] queries, int[][] expected) {
    // given

    // when
    int[][] actual = solution.rangeAddQueries(n, queries);

    // then
    assertThat(actual).isDeepEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            3,
            new int[][] {{1, 1, 2, 2}, {0, 0, 1, 1}},
            new int[][] {{1, 1, 0}, {1, 2, 1}, {0, 1, 1}}),
        Arguments.of(2, new int[][] {{0, 0, 1, 1}}, new int[][] {{1, 1}, {1, 1}}));
  }
}
