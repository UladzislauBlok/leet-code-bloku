package org.bloku.task._3349;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
  void solutionReturnsExpectedResult(List<Integer> nums, int k, boolean expected) {
    // given

    // when
    boolean actual = solution.hasIncreasingSubarrays(nums, k);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3, true),
        Arguments.of(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5, false));
  }
}
