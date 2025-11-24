package org.bloku.task._1018;

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
    void solutionReturnsExpectedResult(int[] nums, List<Boolean> expected) {
        // given

        // when
        List<Boolean> actual = solution.prefixesDivBy5(nums);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[] {0, 1, 1}, List.of(true, false, false)),
                Arguments.of(
                        new int[] {
                            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                        },
                        List.of(
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false, false, false,
                                true, false, false, false, true, false, false, false, true, false,
                                false, false, true, false, false, false, true, false)));
    }
}
