package org.bloku.task._407;

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
  void solutionReturnsExpectedResult(int[][] heightMap, int expected) {
    // given

    // when
    int actual = solution.trapRainWater(heightMap);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {3, 3, 3, 3, 3},
              {3, 2, 2, 2, 3},
              {3, 2, 1, 2, 3},
              {3, 2, 2, 2, 3},
              {3, 3, 3, 2, 2}
            },
            1),
        Arguments.of(
            new int[][] {
              {3, 3, 3, 3, 3},
              {3, 2, 2, 2, 3},
              {3, 2, 1, 2, 3},
              {3, 2, 2, 2, 3},
              {3, 3, 3, 3, 2}
            },
            10),
        Arguments.of(
            new int[][] {
              {14, 17, 12, 13, 20, 14},
              {12, 10, 5, 8, 9, 5},
              {16, 1, 4, 7, 2, 1},
              {17, 4, 3, 1, 7, 2},
              {16, 6, 5, 8, 7, 6},
              {17, 10, 4, 8, 5, 6}
            },
            12));
  }
}
