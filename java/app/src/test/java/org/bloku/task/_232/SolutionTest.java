package org.bloku.task._232;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  private Solution.MyQueue sut;

  @BeforeEach
  public void setUp() {
    this.sut = new Solution.MyQueue();
  }

  @Test
  void tc1() {

    sut.push(1);
    sut.push(2);

    assertThat(sut.peek()).isEqualTo(1);
    assertThat(sut.pop()).isEqualTo(1);
    assertThat(sut.empty()).isFalse();
  }
}
