package org.bloku.task._2273;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Resultant Array After Removing Anagrams")
@Topics({STRING, HASH_TABLE})
class Solution {

  public List<String> removeAnagramsMap(String[] words) {
    List<String> res = new ArrayList<>();
    Map<Character, Integer> prev = Map.of();
    for (String word : words) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : word.toCharArray()) {
        map.merge(c, 1, (k, v) -> v + 1);
      }
      if (!prev.equals(map)) res.add(word);
      prev = map;
    }
    return res;
  }

  public List<String> removeAnagrams(String[] words) {
    List<String> res = new ArrayList<>();
    int[] prev = new int[26];
    for (String word : words) {
      int[] map = new int[26];
      for (char c : word.toCharArray()) {
        map[c - 'a']++;
      }
      if (!Arrays.equals(prev, map)) res.add(word);
      prev = map;
    }
    return res;
  }
}
