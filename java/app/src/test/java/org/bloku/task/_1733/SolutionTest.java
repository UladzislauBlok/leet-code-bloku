package org.bloku.task._1733;

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
  void solutionReturnsExpectedResult(int n, int[][] L, int[][] F, int expected) {
    // given

    // when
    int actual = solution.minimumTeachings(n, L, F);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(2, new int[][] {{1}, {2}, {1, 2}}, new int[][] {{1, 2}, {1, 3}, {2, 3}}, 1),
        Arguments.of(
            3,
            new int[][] {{2}, {1, 3}, {1, 2}, {3}},
            new int[][] {{1, 4}, {1, 2}, {3, 4}, {2, 3}},
            2));
  }
}
