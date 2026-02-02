package org.bloku.task._3539;

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
  void solutionReturnsExpectedResult(int m, int k, int[] nums, int expected) {
    // given

    // when
    int actual = solution.magicalSumDfs(m, k, nums);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(5, 5, new int[] {1, 10, 100, 10000, 1000000}, 991600007),
        Arguments.of(7, 3, new int[] {40, 30}, 229984572));
  }
}
