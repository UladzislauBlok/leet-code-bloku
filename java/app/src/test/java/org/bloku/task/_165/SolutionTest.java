package org.bloku.task._165;

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
  void solutionReturnsExpectedResult(String v1, String v2, int expected) {
    // given

    // when
    int actual = solution.compareVersion(v1, v2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of("1.2", "1.10", -1),
        Arguments.of("1.01", "1.001", 0),
        Arguments.of("1.2.0.0", "1.2.0.0.0.1", -1),
        Arguments.of("1.2.0.0.0.1", "1.2.0.0", 1));
  }
}
