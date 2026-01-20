package org.bloku.task._3314;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(List<Integer> nums, int[] expected) {
        // given

        // when
        int[] actual = solution.minBitwiseArray(nums);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 5, 7), new int[] {-1, 1, 4, 3}),
                Arguments.of(List.of(11, 13, 31), new int[] {9, 12, 15}));
    }
}
