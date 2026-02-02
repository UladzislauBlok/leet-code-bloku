package org.bloku.task._37;

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
  void solutionReturnsExpectedResult(char[][] board, char[][] expected) {
    // given

    // when
    solution.solveSudoku(board);

    // then
    assertThat(board).isDeepEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new char[][] {
              {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
              {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
              {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
              {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
              {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
              {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
              {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
              {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
              {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            },
            new char[][] {
              {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
              {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
              {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
              {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
              {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
              {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
              {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
              {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
              {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
            }));
  }
}
