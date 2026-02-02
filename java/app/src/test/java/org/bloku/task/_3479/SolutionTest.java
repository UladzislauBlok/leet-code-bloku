package org.bloku.task._3479;

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
  void solutionReturnsExpectedResult(int[] fruits, int[] baskets, int expected) {
    // given

    // when
    int actual = solution.numOfUnplacedFruits(fruits, baskets);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {4, 2, 5}, new int[] {3, 5, 4}, 1),
        Arguments.of(new int[] {3, 6, 1}, new int[] {6, 4, 7}, 0));
  }
}
