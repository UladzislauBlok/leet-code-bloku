package org.bloku.task._1578;

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
  void solutionReturnsExpectedResult(String colors, int[] neededTime, int expected) {
    // given

    // when
    int actual = solution.minCost(colors, neededTime);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of("abaac", new int[] {1, 2, 3, 4, 5}, 3),
        Arguments.of("aabaa", new int[] {1, 2, 3, 4, 1}, 2));
  }
}
