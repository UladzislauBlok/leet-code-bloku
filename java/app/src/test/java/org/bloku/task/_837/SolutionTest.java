package org.bloku.task._837;

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
  void solutionReturnsExpectedResult(int n, int k, int maxPts, double expected) {
    // given

    // when
    double actual = solution.new21Game(n, k, maxPts);

    // then
    actual = Math.round(actual * 1e5) / 1e5; // 10^-5 precision
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(10, 1, 10, 1.0),
        Arguments.of(6, 1, 10, 0.6),
        Arguments.of(21, 17, 10, 0.73278));
  }
}
