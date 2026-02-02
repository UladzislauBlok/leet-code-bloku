package org.bloku.task._2200;

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
  void solutionReturnsExpectedResult(int[] nums, int key, int k, List<Integer> expected) {
    // given

    // when
    List<Integer> actual = solution.findKDistantIndices(nums, key, k);

    // then
    assertThat(actual).containsExactlyElementsOf(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {3, 4, 9, 1, 3, 9, 5}, 9, 1, List.of(1, 2, 3, 4, 5, 6)),
        Arguments.of(new int[] {2, 2, 2, 2, 2}, 2, 2, List.of(0, 1, 2, 3, 4)));
  }
}
