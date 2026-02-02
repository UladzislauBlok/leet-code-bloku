package org.bloku.task._1317;

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
  void solutionReturnsExpectedResult(int n, int[] expected) {
    // given

    // when
    int[] actual = solution.getNoZeroIntegers(n);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(2, new int[] {1, 1}),
        Arguments.of(11, new int[] {2, 9}),
        Arguments.of(1010, new int[] {11, 999}));
  }
}
