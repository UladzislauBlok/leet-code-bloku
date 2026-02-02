package org.bloku.task._2197;

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
  void solutionReturnsExpectedResult(int[] nums, List<Integer> expected) {
    // given

    // when
    List<Integer> actual = solution.replaceNonCoprimes(nums);

    // then
    assertThat(actual).containsExactlyElementsOf(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {6, 4, 3, 2, 7, 6, 2}, List.of(12, 7, 6)),
        Arguments.of(new int[] {2, 2, 1, 1, 3, 3, 3}, List.of(2, 1, 1, 3)));
  }
}
