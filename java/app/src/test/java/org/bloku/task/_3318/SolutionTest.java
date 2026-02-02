package org.bloku.task._3318;

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
  void solutionReturnsExpectedResult(int[] nums, int k, int x, int[] expected) {
    // given

    // when
    int[] actual = solution.findXSum(nums, k, x);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 2, 2, 3, 4, 2, 3}, 6, 2, new int[] {6, 10, 12}),
        Arguments.of(new int[] {3, 8, 7, 8, 7, 5}, 2, 2, new int[] {11, 15, 15, 15, 12}));
  }
}
