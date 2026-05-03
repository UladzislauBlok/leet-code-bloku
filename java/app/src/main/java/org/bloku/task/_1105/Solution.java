package org.bloku.task._1105;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Filling Bookcase Shelves")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  private int shelfWidth;
  private int[][] books;
  private int[][] memo;

  public int minHeightShelves(int[][] books, int shelfWidth) {
    this.shelfWidth = shelfWidth;
    this.books = books;
    this.memo = new int[books.length + 1][books.length + 1];
    return dp(0, 0);
  }

  private int dp(int idx, int start) {
    if (memo[idx][start] != 0) return memo[idx][start];
    int width = 0;
    int height = 0;
    for (int i = start; i < idx; i++) {
      width += books[i][0];
      height = Math.max(height, books[i][1]);
    }
    if (idx == books.length) return height;
    int best = dp(idx + 1, idx) + height;
    if (shelfWidth - width >= books[idx][0]) {
      best = Math.min(best, dp(idx + 1, start));
    }
    return memo[idx][start] = best;
  }
}
