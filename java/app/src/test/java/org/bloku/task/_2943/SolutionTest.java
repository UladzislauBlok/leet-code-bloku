package org.bloku.task._2943;

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
    void solutionReturnsExpectedResult(int n, int m, int[] hBars, int[] vBars, int expected) {
        // given

        // when
        int actual = solution.maximizeSquareHoleArea(n, m, hBars, vBars);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(3, 2, new int[] {3, 2, 4}, new int[] {3, 2}, 9),
                Arguments.of(2, 3, new int[] {2, 3}, new int[] {2, 4}, 4));
    }
}
