package org.bloku.task._2942;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Words Containing Character")
@Topics({ARRAY, STRING})
class Solution {

  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) != -1) res.add(i);
    }
    return res;
  }
}
