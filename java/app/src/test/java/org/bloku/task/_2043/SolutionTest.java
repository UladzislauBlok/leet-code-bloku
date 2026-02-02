package org.bloku.task._2043;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void tc1() {
    Solution.Bank sut = new Solution.Bank(new long[] {10, 100, 20, 50, 30});

    assertThat(sut.withdraw(3, 10)).isTrue();
    assertThat(sut.transfer(5, 1, 20)).isTrue();
    assertThat(sut.deposit(5, 20)).isTrue();

    assertThat(sut.transfer(3, 4, 15)).isFalse();
    assertThat(sut.withdraw(10, 50)).isFalse();
  }
}
