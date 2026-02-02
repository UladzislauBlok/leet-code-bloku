package org.bloku.task._1039;

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
  void solutionReturnsExpectedResult(int[] values, int expected) {
    // given

    // when
    int actual = solution.minScoreTriangulation(values);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[] {
              3, 7, 4, 5, 3, 6, 32, 45, 2, 13, 7, 9, 8, 12, 35, 23, 18, 7, 23, 1, 5, 1, 3, 44
            },
            4369),
        Arguments.of(new int[] {3, 7, 4, 5}, 144));
  }
}
