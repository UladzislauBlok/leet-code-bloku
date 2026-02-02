package org.bloku.task._1792;

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
  void solutionReturnsExpectedResult(int[][] classes, int extraStudents, long expected) {
    // given

    // when
    double actual = solution.maxAverageRatio(classes, extraStudents);

    // then
    assertThat(Math.round(actual * 100000)).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 2}, {3, 5}, {2, 2}}, 2, 78333),
        Arguments.of(new int[][] {{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4, 53485));
  }
}
