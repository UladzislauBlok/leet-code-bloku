package org.bloku.task._1625;

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
  void solutionReturnsExpectedResult(String s, int a, int b, String expected) {
    // given

    // when
    String actual = solution.findLexSmallestString(s, a, b);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of("5525", 9, 2, "2050"),
        Arguments.of(
            "552345678987654354567898765434567895", 5, 3, "007890123432109809012343210989012340"));
  }
}
