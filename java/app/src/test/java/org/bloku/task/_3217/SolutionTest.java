package org.bloku.task._3217;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bloku.util.ListUtil.buildListNode;

import java.util.List;
import java.util.stream.Stream;
import org.bloku.domain.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() {
    this.solution = new Solution();
  }

  @ParameterizedTest
  @MethodSource
  void solutionReturnsExpectedResult(int[] nums, ListNode head, ListNode expected) {
    // given

    // when
    ListNode actual = solution.modifiedList(nums, head);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(
            new int[] {1, 2, 3},
            buildListNode(List.of(1, 2, 3, 4, 5)),
            buildListNode(List.of(4, 5))),
        Arguments.of(
            new int[] {17, 19, 31, 33, 49, 51, 63, 65, 79, 81, 99, 101, 119},
            buildListNode(
                List.of(
                    11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49,
                    51, 53, 55, 57, 59, 61, 63, 65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89,
                    91, 93, 95, 97, 99, 101, 103, 105, 107, 109, 111, 113, 115, 117, 119, 121)),
            buildListNode(
                List.of(
                    11, 13, 15, 21, 23, 25, 27, 29, 35, 37, 39, 41, 43, 45, 47, 53, 55, 57, 59, 61,
                    67, 69, 71, 73, 75, 77, 83, 85, 87, 89, 91, 93, 95, 97, 103, 105, 107, 109, 111,
                    113, 115, 117, 121))));
  }
}
