package org.bloku.task._2976;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost,
            long expected) {
        // given

        // when
        long actual = solution.minimumCost(source, target, original, changed, cost);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        "abcd",
                        "acbe",
                        new char[] {'a', 'b', 'c', 'c', 'e', 'd'},
                        new char[] {'b', 'c', 'b', 'e', 'b', 'e'},
                        new int[] {2, 5, 5, 1, 2, 20},
                        28),
                Arguments.of(
                        "aaaa",
                        "bbbb",
                        new char[] {'a', 'c'},
                        new char[] {'c', 'b'},
                        new int[] {1, 2},
                        12));
    }
}
