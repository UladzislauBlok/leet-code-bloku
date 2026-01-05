package org.bloku.task._1975;

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
    void solutionReturnsExpectedResult(int[][] matrix, long expected) {
        // given

        // when
        long actual = solution.maxMatrixSum(matrix);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        new int[][] {
                            {1, 1, 1, 1, -1},
                            {1, 1, -1, 1, 1},
                            {1, 1, 1, 1, 1},
                            {1, 1, 1, 1, 1},
                            {1, -1, 1, 1, 1}
                        },
                        23),
                Arguments.of(new int[][] {{1, 2, 3}, {-1, 2, -3}, {1, -2, 3}}, 16));
    }
}
