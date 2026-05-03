package org.bloku.task._2452;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Words Within Two Edits of Dictionary")
@Topics({ARRAY, STRING, TRIE})
class Solution {

  public List<String> twoEditWords(String[] queries, String[] dictionary) {
    Map<Integer, List<String>> map = new HashMap<>();
    for (String word : dictionary) {
      int hash = 0;
      for (char c : word.toCharArray()) {
        hash += c;
      }
      map.computeIfAbsent(hash, __ -> new ArrayList<>()).add(word);
    }
    List<String> result = new ArrayList<>();
    for (String query : queries) {
      int hash = 0;
      for (char c : query.toCharArray()) {
        hash += c;
      }
      for (int i = hash - 50; i <= hash + 50; i++) {
        if (!map.containsKey(i)) continue;
        boolean good = false;
        for (String word : map.get(i)) {
          int diff = 0;
          for (int j = 0; j < word.length() && diff <= 2; j++) {
            if (word.charAt(j) != query.charAt(j)) diff++;
          }
          if (diff <= 2) {
            good = true;
            break;
          }
        }
        if (good) {
          result.add(query);
          break;
        }
      }
    }
    return result;
  }

  /*
      we need to preprocess dictionary and do effective look up
      natural solution would be to use hash smtg, but the question is
      how to find not exact but close match
      1 <= n <= 100, even n^2 will do, but can it be any better?
      hash with bitmask? yes
      ~ we can convert query to int[] f, but how to effectively look up it? ~
      ~ we length is the same we can just convert string to int and later search for everything ~
      ~ within int(query) +- 52 (max 26 * 2); actually event +- 52 isn't bad ~
      ~ max diff is a|a -> zz == 0|0 -> 25|25 == 0 -> 50 (not 52) ~
  */
}
