package org.bloku.task._3397;

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
  void solutionReturnsExpectedResult(int[] nums, int k, int expected) {
    // given

    // when
    int actual = solution.maxDistinctElements(nums, k);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[] {
              1, 2, 2, 3, 2342, 43, 234, 4324, 5, 4, 56, 7, 7, 12, 4, 6, 5, 56, 567, 4, 6, 3, 36,
              34, 63, 65, 567, 97, 9, 4, 56, 5, 6, 67, 64, 5234, 23, 5432, 432, 4, 56, 3, 4, 43,
              234, 4324, 5, 4, 56, 7, 7, 12, 4, 6, 7, 7, 12, 4, 6, 5, 56, 567, 4, 6, 3, 36, 34, 63,
              65, 567, 97, 9, 4, 56, 5, 6, 67, 64, 5234, 23, 5432, 432, 4, 56, 3, 4, 43, 234, 4324,
              5, 4, 56, 7, 7, 12, 4, 6, 7, 7, 12, 4, 6, 5, 56, 567, 4, 6, 3, 36, 34, 63, 65, 567,
              97, 9, 4, 56, 5, 6, 67, 64, 5234, 23, 5432, 432, 4, 56, 3, 4, 43, 234, 4324, 5, 4, 56,
              7, 7, 12, 4, 6, 7, 7, 12, 4, 6, 5, 56, 567, 4, 6, 3, 36, 34, 63, 65, 567, 97, 9, 4,
              56, 5, 6, 67, 64, 5234, 23, 5432, 432, 4, 56, 3, 4, 43, 234, 4324, 5, 4, 56, 7, 7, 12,
              4, 6, 7, 7, 12, 4, 6, 5, 56, 567, 4, 6, 3, 36, 34, 63, 65, 567, 97, 9, 4, 56, 5, 6,
              67, 64, 5234, 23, 5432, 432, 4, 56, 3, 4, 43, 234, 4324, 5, 4, 56, 7, 7, 12, 4, 6
            },
            7,
            116),
        Arguments.of(new int[] {1, 2, 2, 3, 3, 4}, 2, 6),
        Arguments.of(new int[] {4, 4, 4, 4}, 1, 3));
  }
}
