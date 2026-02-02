package org.bloku.task._966;

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
  void solutionReturnsExpectedResult(String[] wordlist, String[] queries, String[] expected) {
    // given

    // when
    String[] actual = solution.spellchecker(wordlist, queries);

    // then
    assertThat(actual).containsExactly(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new String[] {"KiTe", "kite", "hare", "Hare"},
            new String[] {
              "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"
            },
            new String[] {"kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"}),
        Arguments.of(
            new String[] {"v", "t", "k", "g", "n", "k", "u", "h", "m", "p"},
            new String[] {"n", "g", "k", "q", "m", "h", "x", "t", "p", "p"},
            new String[] {"n", "g", "k", "", "m", "h", "", "t", "p", "p"}));
  }
}
