package org.bloku.task._2942;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
  void solutionReturnsExpectedResult(String[] words, char target, List<Integer> expected) {
    // given

    // when
    List<Integer> actual = solution.findWordsContaining(words, target);

    // then
    assertThat(actual).containsExactlyElementsOf(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new String[] {"leet", "code"}, 'e', List.of(0, 1)),
        Arguments.of(new String[] {"abc", "bcd", "aaaa", "cbc"}, 'a', List.of(0, 2)));
  }
}
