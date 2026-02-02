package org.bloku.task._3494;

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
  void solutionReturnsExpectedResult(int[] skill, int[] mana, long expected) {
    // given

    // when
    long actual = solution.minTime(skill, mana);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {1, 5, 2, 4}, new int[] {5, 1, 4, 2}, 110),
        Arguments.of(new int[] {1, 2, 3, 4}, new int[] {1, 2}, 21));
  }
}
