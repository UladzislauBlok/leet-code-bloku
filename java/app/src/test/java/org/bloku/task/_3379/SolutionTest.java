package org.bloku.task._3379;

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
  void solutionReturnsExpectedResult(int[] nums, int[] expected) {
    // given

    // when
    int[] actual = solution.constructTransformedArray(nums);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {3, -2, 1, 1}, new int[] {1, 1, 1, 3}),
        Arguments.of(new int[] {-1, 4, -1}, new int[] {-1, -1, 4}));
  }
}
