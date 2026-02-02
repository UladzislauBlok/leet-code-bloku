package org.bloku.task._3652;

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
  void solutionReturnsExpectedResult(int[] prices, int[] strategy, int k, long expected) {
    // given

    // when
    long actual = solution.maxProfit(prices, strategy, k);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {4, 2, 8}, new int[] {-1, 0, 1}, 2, 10),
        Arguments.of(new int[] {5, 4, 3}, new int[] {1, 1, 0}, 2, 9));
  }
}
