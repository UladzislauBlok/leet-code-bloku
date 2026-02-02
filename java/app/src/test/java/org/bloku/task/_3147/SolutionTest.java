package org.bloku.task._3147;

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
  void solutionReturnsExpectedResult(int[] energy, int k, int expected) {
    // given

    // when
    int actual = solution.maximumEnergy(energy, k);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {5, 2, -10, -5, 1}, 3, 3),
        Arguments.of(new int[] {-3, -2, -1}, 2, -1),
        Arguments.of(new int[] {10, -10, 10, -10, 10, 100, 10, 100}, 2, 200));
  }
}
