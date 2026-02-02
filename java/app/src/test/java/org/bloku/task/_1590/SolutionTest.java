package org.bloku.task._1590;

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
  void solutionReturnsExpectedResult(int[] nums, int p, int expected) {
    // given

    // when
    int actual = solution.minSubarray(nums, p);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {3, 1, 4, 2}, 6, 1),
        Arguments.of(new int[] {6, 3, 5, 2}, 9, 2),
        Arguments.of(new int[] {15, 15, 15, 16}, 16, 3));
  }
}
