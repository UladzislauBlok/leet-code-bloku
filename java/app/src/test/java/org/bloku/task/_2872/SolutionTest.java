package org.bloku.task._2872;

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
    void solutionReturnsExpectedResult(int n, int[][] edges, int[] values, int k, int expected) {
        // given

        // when
        int actual = solution.maxKDivisibleComponents(n, edges, values, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        5,
                        new int[][] {{0, 2}, {1, 2}, {1, 3}, {2, 4}},
                        new int[] {1, 8, 1, 4, 4},
                        6,
                        2),
                Arguments.of(
                        7,
                        new int[][] {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}},
                        new int[] {3, 0, 6, 1, 5, 2, 1},
                        3,
                        3));
    }
}
