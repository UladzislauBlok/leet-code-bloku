// package org.bloku.task.TODO;
//
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.Arguments;
// import org.junit.jupiter.params.provider.MethodSource;
//
// import java.util.stream.Stream;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// class SolutionTest {
//
//    private Solution solution;
//
//    @BeforeEach
//    public void setUp() {
//        this.solution = new Solution();
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    void solutionReturnsExpectedResult(int expected) {
//        // given
//
//        // when
//        int actual = solution.f();
//
//        // then
//        assertThat(actual).isEqualTo(expected);
//    }
//
//    static Stream<Arguments> solutionReturnsExpectedResult() {
//        return Stream.of(
//                Arguments.of(10),
//                Arguments.of(4)
//        );
//    }
// }
//
