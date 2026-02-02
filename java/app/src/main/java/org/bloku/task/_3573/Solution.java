package org.bloku.task._3573;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Best Time to Buy and Sell Stock V")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  private long[] memo;
  private int[] prices;

  // leetcode
  public long maximumProfit(int[] prices, int k) {
    int n = prices.length;
    long[][] dp = new long[k + 1][3];
    // initialize the state on day 0
    for (int j = 1; j <= k; j++) {
      dp[j][1] = -prices[0];
      dp[j][2] = prices[0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = k; j > 0; j--) {
        dp[j][0] = Math.max(dp[j][0], Math.max(dp[j][1] + prices[i], dp[j][2] - prices[i]));
        dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
        dp[j][2] = Math.max(dp[j][2], dp[j - 1][0] + prices[i]);
      }
    }

    return dp[k][0];
  }

  // my
  public long maximumProfit_(int[] prices, int k) {
    this.prices = prices;
    int n = prices.length;
    this.memo = new long[n * 1000 + n / 2 + 3];
    return dp(0, k);
  }

  public long dp(int pos, int k) {
    int key = pos * 1000 + k;
    if (memo[key] != 0) return memo[key];
    int n = prices.length;
    if (pos >= n || k == 0) return 0;
    long best = dp(pos + 1, k); // skip curr
    long bestTmp = 0;
    for (int i = pos + 1; i < n; i++) {
      long tmp = Math.abs(prices[pos] - prices[i]); // operate on curr
      bestTmp = Math.max(bestTmp, tmp);
      if (tmp < bestTmp) continue;
      tmp += dp(i + 1, k - 1);
      best = Math.max(best, tmp);
    }
    memo[key] = best;
    return best;
  }

  /*
      find sum of k best pair
      Two types of ftransactions mean we just use absolute difference
      We can't do transaction while in the midddle of another one, meaning no overlap
  */

  /*
      class Data{
      long profit=0, buy=0, sell=0;
      Data(long profit, long buy, long sell){
          this.profit=profit;
          this.buy=buy;
          this.sell=sell;
      }
  }
  class Solution {
      static public long maximumProfit(int[] prices, int k) {
          final int x0=prices[0], n=prices.length;
          Data [] dp=new Data[k+1];
          for (int t=0; t<=k; t++)
              dp[t]=new Data(0, -x0, x0);
          for(int i=1; i<n; i++){
              final int x=prices[i];
              for(int t=k; t>0; t--){
                  Data cur=dp[t];
                  long prevP=dp[t-1].profit;
                  cur.profit=Math.max(cur.profit, Math.max(cur.buy+x, cur.sell-x));
                  cur.buy=Math.max(cur.buy,  prevP-x);
                  cur.sell=Math.max(cur.sell, prevP+x);
              }
          }
          return dp[k].profit;
      }
  }
      */
}
