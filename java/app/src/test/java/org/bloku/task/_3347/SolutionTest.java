package org.bloku.task._3347;

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
        Arguments.of(
            new int[] {
              1,
              4,
              5,
              5,
              10000000,
              15555,
              10000009,
              11000000,
              10000070,
              17000000,
              10000300,
              1000000000
            },
            1,
            3,
            3),
        Arguments.of(new int[] {5, 11, 20, 20}, 5, 1, 2),
        Arguments.of(new int[] {1, 78, 70}, 39, 3, 3));
  }
}
