package org.bloku.task._3531;

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
    void solutionReturnsExpectedResult(int n, int[][] buildings, int expected) {
        // given

        // when
        int actual = solution.countCoveredBuildings(n, buildings);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(3, new int[][] {{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}}, 1),
                Arguments.of(3, new int[][] {{1, 1}, {1, 2}, {2, 1}, {2, 2}}, 0));
    }
}
