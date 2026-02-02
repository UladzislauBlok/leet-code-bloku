package org.bloku.task._2257;

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
  void solutionReturnsExpectedResult(int m, int n, int[][] guards, int[][] walls, int expected) {
    // given

    // when
    int actual = solution.countUnguarded(m, n, guards, walls);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            4, 6, new int[][] {{0, 0}, {1, 1}, {2, 3}}, new int[][] {{0, 1}, {2, 2}, {1, 4}}, 7),
        Arguments.of(
            29,
            51,
            new int[][] {{25, 11}, {11, 7}, {18, 35}, {22, 16}, {8, 43}, {27, 15}, {19, 3}},
            new int[][] {
              {24, 1}, {19, 23}, {18, 14}, {12, 17}, {12, 47}, {21, 35}, {18, 45}, {4, 50}
            },
            1009));
  }
}
