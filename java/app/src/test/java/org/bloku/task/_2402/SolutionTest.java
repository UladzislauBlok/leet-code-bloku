package org.bloku.task._2402;

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
    void solutionReturnsExpectedResult(int n, int[][] meetings, int expected) {
        // given

        // when
        int actual = solution.mostBooked(n, meetings);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        4,
                        new int[][] {
                            {6, 41}, {13, 31}, {22, 30}, {24, 34}, {25, 36}, {31, 46}, {32, 36},
                            {37, 46}, {48, 49}, {49, 50}
                        },
                        0),
                Arguments.of(3, new int[][] {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}, 1));
    }
}
