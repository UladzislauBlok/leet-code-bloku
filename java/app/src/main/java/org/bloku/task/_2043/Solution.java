package org.bloku.task._2043;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Simple Bank System")
@Topics({SIMULATION, DESIGN, ARRAY})
class Solution {

  static class Bank {

    private final int n;
    private final long[] balance;

    public Bank(long[] balance) {
      this.n = balance.length;
      this.balance = new long[n + 1];
      for (int i = 0; i < n; i++) {
        this.balance[i + 1] = balance[i];
      }
    }

    public boolean transfer(int account1, int account2, long money) {
      if (account1 > n || account2 > n) return false;
      if (balance[account1] < money) return false;
      balance[account1] -= money;
      balance[account2] += money;
      return true;
    }

    public boolean deposit(int account, long money) {
      if (account > n) return false;
      balance[account] += money;
      return true;
    }

    public boolean withdraw(int account, long money) {
      if (account > n) return false;
      if (balance[account] < money) return false;
      balance[account] -= money;
      return true;
    }
  }
}
