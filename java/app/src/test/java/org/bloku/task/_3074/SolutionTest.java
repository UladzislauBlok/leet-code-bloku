package org.bloku.task._3074;

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
  void solutionReturnsExpectedResult(int[] apples, int[] capacity, int expected) {
    // given

    // when
    int actual = solution.minimumBoxes(apples, capacity);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 2}, new int[] {4, 3, 1, 5, 2}, 2),
        Arguments.of(new int[] {5, 5, 5}, new int[] {2, 4, 2, 7}, 4));
  }
}
