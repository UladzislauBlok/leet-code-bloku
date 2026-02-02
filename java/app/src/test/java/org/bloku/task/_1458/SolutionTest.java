package org.bloku.task._1458;

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
  void solutionReturnsExpectedResult(int[] nums1, int[] nums2, int expected) {
    // given

    // when
    int actual = solution.maxDotProduct(nums1, nums2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {2, 1, -2, 5}, new int[] {3, 0, -6}, 18),
        Arguments.of(
            new int[] {7, 2, 2, -1, -1, 1, -4, 7, 6},
            new int[] {-7, -9, -1, 2, 2, 5, -7, 2, -7, 5},
            108));
  }
}
