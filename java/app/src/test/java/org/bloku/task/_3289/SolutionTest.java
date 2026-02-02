package org.bloku.task._3289;

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
    int[] actual = solution.getSneakyNumbers(nums);

    // then
    assertThat(actual).containsExactlyInAnyOrder(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {0, 1, 1, 0}, new int[] {0, 1}),
        Arguments.of(new int[] {7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2}, new int[] {4, 5}));
  }
}
