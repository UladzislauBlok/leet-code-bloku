package org.bloku.task._3346;

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
  void solutionReturnsExpectedResult(int[] nums, int k, int numOperations, int expected) {
    // given

    // when
    int actual = solution.maxFrequency(nums, k, numOperations);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 4, 5, 4, 4, 5}, 3, 4, 7),
        Arguments.of(
            new int[] {
              1, 3, 4, 4, 3, 4, 5, 4, 3, 3, 4, 65, 56, 745, 5634, 56, 4356, 354, 6, 3456, 354, 6732,
              4657, 4546, 7, 5466, 543, 6745, 67, 4657, 4657, 456, 74, 567, 456, 7456, 7, 345,
              76547, 87, 2376, 83, 36457, 68746, 7, 5, 7665, 53, 654, 73, 45676, 4567, 65, 5, 6, 4,
              4, 9
            },
            1002,
            8,
            15));
  }
}
