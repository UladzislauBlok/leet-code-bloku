package org.bloku.task._2092;

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
    void solutionReturnsExpectedResult(
            int persons, int[][] meetings, int firstPerson, List<Integer> expected) {
        // given

        // when
        List<Integer> actual = solution.findAllPeople(persons, meetings, firstPerson);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        6,
                        new int[][] {{1, 2, 5}, {2, 3, 8}, {1, 5, 10}},
                        1,
                        List.of(0, 1, 2, 3, 5)),
                Arguments.of(
                        4, new int[][] {{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3, List.of(0, 1, 3)));
    }
}
