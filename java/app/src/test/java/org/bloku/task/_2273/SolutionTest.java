package org.bloku.task._2273;

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
  void solutionReturnsExpectedResult(String[] words, List<String> expected) {
    // given

    // when
    List<String> actual = solution.removeAnagrams(words);

    // then
    assertThat(actual).containsExactlyElementsOf(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(new String[] {"abba", "baba", "bbaa", "cd", "cd"}, List.of("abba", "cd")),
        Arguments.of(new String[] {"a", "b", "a"}, List.of("a", "b", "a")));
  }
}
