package org.bloku.task._2570;

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
  void solutionReturnsExpectedResult(int[][] nums1, int[][] nums2, int[][] expected) {
    // given

    // when
    int[][] actual = solution.mergeArrays(nums1, nums2);

    // then
    assertThat(actual).isDeepEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[][] {{1, 2}, {2, 3}, {4, 5}},
            new int[][] {{1, 4}, {3, 2}, {4, 1}},
            new int[][] {{1, 6}, {2, 3}, {3, 2}, {4, 6}}),
        Arguments.of(
            new int[][] {{2, 4}, {3, 6}, {5, 5}},
            new int[][] {{1, 3}, {4, 3}},
            new int[][] {{1, 3}, {2, 4}, {3, 6}, {4, 3}, {5, 5}}));
  }
}
