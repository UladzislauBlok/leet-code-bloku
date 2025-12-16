package org.bloku.task._3562;

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
            int n, int[] present, int[] future, int[][] hierarchy, int budget, int expected) {
        // given

        // when
        int actual = solution.maxProfit(n, present, future, hierarchy, budget);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        20,
                        new int[] {
                            1, 17, 1, 21, 2, 25, 17, 10, 23, 28, 9, 46, 18, 32, 34, 31, 49, 24, 23,
                            9
                        },
                        new int[] {
                            29, 9, 14, 8, 12, 40, 6, 50, 45, 33, 22, 21, 2, 47, 16, 28, 18, 48, 15,
                            22
                        },
                        new int[][] {
                            {1, 3}, {1, 9}, {1, 18}, {1, 12}, {12, 15}, {18, 17}, {1, 19}, {17, 4},
                            {3, 16}, {18, 2}, {3, 14}, {9, 8}, {18, 11}, {3, 20}, {20, 6}, {17, 5},
                            {14, 7}, {17, 13}, {20, 10}
                        },
                        11,
                        82),
                Arguments.of(
                        2, new int[] {33, 13}, new int[] {34, 15}, new int[][] {{1, 2}}, 20, 2));
    }
}
