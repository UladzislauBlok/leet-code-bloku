package org.bloku.task._474;

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
  void solutionReturnsExpectedResult(String[] strs, int m, int n, int expected) {
    // given

    // when
    int actual = solution.findMaxForm(strs, m, n);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3, 4),
        Arguments.of(new String[] {"10", "0", "1"}, 1, 1, 2));
  }
}
