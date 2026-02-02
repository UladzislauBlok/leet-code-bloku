package org.bloku.task._1514;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.assertj.core.data.Offset;
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
  void solutionReturnsExpectedResult(
      int n, int[][] edges, double[] succProb, int startNode, int endNode, double expected) {
    // given

    // when
    double actual = solution.maxProbability(n, edges, succProb, endNode, startNode);

    // then
    assertThat(actual).isEqualTo(expected, Offset.offset(0.00001));
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            3, new int[][] {{0, 1}, {1, 2}, {0, 2}}, new double[] {0.5, 0.5, 0.2}, 0, 2, 0.25),
        Arguments.of(
            500,
            new int[][] {{193, 229}, {133, 212}, {224, 465}},
            new double[] {0.91, 0.78, 0.64},
            4,
            364,
            0.0));
  }
}
