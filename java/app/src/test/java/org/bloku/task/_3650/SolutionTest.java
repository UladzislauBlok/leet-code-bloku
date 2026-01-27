package org.bloku.task._3650;

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
    void solutionReturnsExpectedResult(int n, int[][] edges, int expected) {
        // given

        // when
        int actual = solution.minCost(n, edges);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(4, new int[][] {{0, 1, 3}, {3, 1, 1}, {2, 3, 4}, {0, 2, 2}}, 5),
                Arguments.of(4, new int[][] {{0, 2, 1}, {2, 1, 1}, {1, 3, 1}, {2, 3, 3}}, 3));
    }
}
