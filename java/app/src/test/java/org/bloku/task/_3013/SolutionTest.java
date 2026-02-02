package org.bloku.task._3013;

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
  void solutionReturnsExpectedResult(int[] nums, int k, int dist, long expected) {
    // given

    // when
    long actual = solution.minimumCost(nums, k, dist);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 2, 6, 4, 2}, 3, 3, 5),
        Arguments.of(new int[] {10, 1, 2, 2, 2, 1}, 4, 3, 15),
        Arguments.of(new int[] {10, 8, 18, 9}, 3, 1, 36));
  }
}
