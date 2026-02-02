package org.bloku.task._3453;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.assertj.core.data.Offset;
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
  void solutionReturnsExpectedResult(int[][] squares, double expected) {
    // given

    // when
    double actual = solution.separateSquares(squares);

    // then
    assertThat(actual).isEqualTo(expected, Offset.offset(0.00001));
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new int[][] {{0, 0, 1}, {2, 2, 1}}, 1),
        Arguments.of(
            new int[][] {
              {522261215, 954313664, 225462},
              {628661372, 718610752, 10667},
              {619734768, 941310679, 44788},
              {352367502, 656774918, 289036},
              {860247066, 905800565, 100123},
              {817623994, 962847576, 71460},
              {691552058, 782740602, 36271},
              {911356, 152015365, 513881},
              {462847044, 859151855, 233567},
              {672324240, 954509294, 685569}
            },
            954521423.80203));
  }
}
