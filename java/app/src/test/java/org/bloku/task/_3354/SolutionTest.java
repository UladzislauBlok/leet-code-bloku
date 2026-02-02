package org.bloku.task._3354;

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
    int actual = solution.countValidSelections(nums);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {1, 0, 2, 0, 3}, 2),
        Arguments.of(
            new int[] {
              46, 53, 45, 49, 53, 45, 47, 44, 46, 37, 50, 39, 53, 52, 48, 42, 40, 48, 43, 41, 51,
              45, 41, 43, 49, 44, 45, 45, 43, 51, 51, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
              0, 0, 0, 0, 0, 0, 0, 0, 35, 39, 40, 41, 34, 40, 40, 32, 27, 27, 41, 40, 39, 42, 32,
              52, 32, 29, 35, 40, 32, 37, 28, 34, 42, 33, 38, 40, 40, 40, 38, 38, 30, 38, 38, 43,
              36, 36, 38, 40
            },
            22));
  }
}
