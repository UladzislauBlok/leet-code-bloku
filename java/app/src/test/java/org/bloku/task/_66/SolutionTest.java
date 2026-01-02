package org.bloku.task._66;

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
    void solutionReturnsExpectedResult(int[] digits, int[] expected) {
        // given

        // when
        int[] actual = solution.plusOne(digits);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3}, new int[] {1, 2, 4}),
                Arguments.of(new int[] {9}, new int[] {1, 0}));
    }
}
