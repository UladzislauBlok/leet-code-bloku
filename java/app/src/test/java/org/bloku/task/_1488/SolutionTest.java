package org.bloku.task._1488;

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
  void solutionReturnsExpectedResult(int[] rain, int[] expected) {
    // given

    // when
    int[] actual = solution.avoidFlood(rain);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 0, 0, 2, 1}, new int[] {-1, -1, 2, 1, -1, -1}),
        Arguments.of(new int[] {1, 2, 0, 1, 2}, new int[] {}),
        Arguments.of(new int[] {69, 0, 0, 0, 69}, new int[] {-1, 69, 1, 1, -1}));
  }
}
