package org.bloku.task._3607;

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
  void solutionReturnsExpectedResult(int c, int[][] connections, int[][] queries, int[] expected) {
    // given

    // when
    int[] actual = solution.processQueries(c, connections, queries);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            5,
            new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
            new int[][] {{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}},
            new int[] {3, 2, 3}),
        Arguments.of(3, new int[][] {}, new int[][] {{1, 1}, {2, 1}, {1, 1}}, new int[] {1, -1}));
  }
}
