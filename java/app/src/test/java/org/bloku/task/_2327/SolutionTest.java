package org.bloku.task._2327;

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
  void solutionReturnsExpectedResult(int n, int delay, int forget, int expected) {
    // given

    // when
    int actual = solution.peopleAwareOfSecret(n, delay, forget);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(6, 2, 4, 5), Arguments.of(4, 1, 3, 6), Arguments.of(888, 3, 154, 556074482));
  }
}
