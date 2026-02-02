package org.bloku.task._2099;

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
  void solutionReturnsExpectedResult(int[] nums, int k, int[] expected) {
    // given

    // when
    int[] actual = solution.maxSubsequence(nums, k);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {2, 1, 3, 3}, 2, new int[] {3, 3}),
        Arguments.of(new int[] {-1, -2, 3, 4}, 3, new int[] {-1, 3, 4}),
        Arguments.of(new int[] {3, 4, 3, 3}, 2, new int[] {3, 4}));
  }
}
