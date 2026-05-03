package org.bloku.task._1554;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Strings Differ by One Character")
@Topics({STRING, TRIE, HASH_TABLE})
class Solution {

  public boolean differByOneTrie(String[] dict) {
    Trie[] tries = new Trie[26];
    for (char c = 'a'; c <= 'z'; c++) {
      tries[c - 'a'] = new Trie(c);
    }
    for (String word : dict) {
      char[] str = word.toCharArray();
      for (char c = 'a'; c <= 'z'; c++) {
        if (tries[c - 'a'].find(str, 0, false)) return true;
      }
      tries[str[0] - 'a'].put(str, 0);
    }
    return false;
  }

  /*
      trie?
  */

  private final class Trie {
    private final char value;
    private final Trie[] nodes = new Trie[26];

    Trie(char c) {
      this.value = c;
    }

    boolean find(char[] str, int idx, boolean changed) {
      if (idx == str.length - 1 && (str[idx] == value || !changed)) return true;
      if (str[idx] != value && changed) return false;
      boolean good = false;
      changed = changed || (str[idx] != value);
      for (Trie child : nodes) {
        if (child == null) continue;
        good = child.find(str, idx + 1, changed);
        if (good) break;
      }
      return good;
    }

    void put(char[] str, int idx) {
      if (idx == str.length - 1) return;
      int next = str[idx + 1] - 'a';
      if (nodes[next] == null) nodes[next] = new Trie(str[idx + 1]);
      nodes[next].put(str, idx + 1);
    }
  }
}
