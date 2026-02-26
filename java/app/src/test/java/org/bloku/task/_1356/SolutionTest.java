package org.bloku.task._1356;

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
  void solutionReturnsExpectedResult(int[] arr, int[] expected) {
    // given

    // when
    int[] actual = solution.sortByBits(arr);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, new int[] {0, 1, 2, 4, 8, 3, 5, 6, 7}),
        Arguments.of(
            new int[] {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1},
            new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}));
  }
}
