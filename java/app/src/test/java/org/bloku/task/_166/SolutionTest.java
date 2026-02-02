package org.bloku.task._166;

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
  void solutionReturnsExpectedResult(int numerator, int denominator, String expected) {
    // given

    // when
    String actual = solution.fractionToDecimal(numerator, denominator);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(1, 2, "0.5"),
        Arguments.of(2, 1, "2"),
        Arguments.of(4, 333, "0.(012)"),
        Arguments.of(-1, -2147483648, "0.0000000004656612873077392578125"));
  }
}
