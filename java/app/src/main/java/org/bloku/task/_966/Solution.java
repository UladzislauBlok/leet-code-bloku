package org.bloku.task._966;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Vowel Spellchecker")
@Topics({STRING, HASH_TABLE})
class Solution {

  // if exact match -> skip checking
  // replace vowel with _ and check first match from wordlist
  public String[] spellchecker(String[] wordlist, String[] queries) {
    int n = queries.length;
    String[] res = new String[n];
    Set<String> wordSet = new HashSet<>(); // priority 1
    Map<String, String> caseMap = new HashMap<>(); // priority 2
    Map<String, String> patternMap = new HashMap<>(); // priority 3
    for (String word : wordlist) {
      wordSet.add(word);
      caseMap.putIfAbsent(word.toLowerCase(), word);
      String pattern = makePattern(word);
      patternMap.putIfAbsent(pattern, word);
    }
    for (int i = 0; i < n; i++) {
      String query = queries[i];
      if (wordSet.contains(query)) {
        res[i] = query;
      } else if (caseMap.containsKey(query.toLowerCase())) {
        res[i] = caseMap.get(query.toLowerCase());
      } else {
        String pattern = makePattern(query);
        res[i] = patternMap.getOrDefault(pattern, "");
      }
    }
    return res;
  }

  private String makePattern(String str) {
    char[] chars = str.toLowerCase().toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      switch (c) {
        case 'a', 'e', 'i', 'o', 'u':
          chars[i] = '_';
      }
    }
    return new String(chars);
  }
}
