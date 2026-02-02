package org.bloku.task._11;

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
  void solutionReturnsExpectedResult(int[] height, int expected) {
    // given

    // when
    int actual = solution.maxArea(height);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[] {
              1, 8, 6, 2, 5, 4, 8, 3, 7, 1, 8, 6, 2, 5, 4, 8, 3, 7, 2341, 4242, 352, 5, 225, 2,
              5345, 3, 2532, 2346, 775, 8, 32, 657, 1, 8, 6, 2, 5, 4, 8, 3, 7, 1, 8, 6, 2, 5, 4, 8,
              3, 7, 2341, 4242, 352, 5, 225, 2, 5345, 3, 2532, 2346, 775, 8, 32, 657, 1, 8, 6, 2, 5,
              4, 8, 3, 7, 1, 8, 6, 2, 5, 4, 8, 3, 7, 2341, 4342, 352, 5, 225, 2, 5345, 3, 2532,
              2346, 775, 8, 32, 657
            },
            342080),
        Arguments.of(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}, 49));
  }
}
