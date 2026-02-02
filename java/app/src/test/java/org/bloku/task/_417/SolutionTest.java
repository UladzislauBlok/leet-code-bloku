package org.bloku.task._417;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
  void solutionReturnsExpectedResult(int[][] heights, List<List<Integer>> expected) {
    // given

    // when
    List<List<Integer>> actual = solution.pacificAtlantic(heights);

    // then
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {1, 2, 2, 3, 5},
              {3, 2, 3, 4, 4},
              {2, 4, 5, 3, 1},
              {6, 7, 1, 4, 5},
              {5, 1, 1, 2, 4}
            },
            List.of(
                List.of(0, 4),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 2),
                List.of(3, 0),
                List.of(3, 1),
                List.of(4, 0))),
        Arguments.of(new int[][] {{1}}, List.of(List.of(0, 0))));
  }
}
