package org.bloku.task._225;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  private Solution.MyStack sut;

  @BeforeEach
  public void setUp() {
    this.sut = new Solution.MyStack();
  }

  @Test
  void tc1() {
    sut.push(1);
    sut.push(2);

    assertThat(sut.top()).isEqualTo(2);
    assertThat(sut.pop()).isEqualTo(2);
    assertThat(sut.empty()).isFalse();
  }
}
