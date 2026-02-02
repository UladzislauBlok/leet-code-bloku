package org.bloku.task._2654;

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
  void solutionReturnsExpectedResult(int[] nums, int expected) {
    // given

    // when
    int actual = solution.minOperations(nums);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {6, 10, 15}, 4),
        Arguments.of(
            new int[] {
              2, 6, 3, 4, 2, 6, 3, 4, 2, 6, 3, 4, 2, 6, 3, 4, 8, 7, 4, 6, 8, 9, 9, 123, 43546, 7675,
              4523, 2334
            },
            28));
  }
}
