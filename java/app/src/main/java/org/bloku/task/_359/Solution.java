package org.bloku.task._359;

import static org.bloku.util.Topic.*;

import java.util.HashSet;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Logger Rate Limiter")
@Topics({DESIGN, DESIGN, RING_BUFFER})
class Solution {

  private static final Integer TIME_THRESHOLD = 10;
  private static final Aggregate EMPTY_AGGREGATE = new Aggregate(-1, Set.of());

  private final Aggregate[] loggedMessages;
  private int bufferPointer;

  Solution() {
    loggedMessages = new Aggregate[TIME_THRESHOLD];
    for (int i = 0; i < TIME_THRESHOLD; i++) {
      loggedMessages[i] = EMPTY_AGGREGATE;
    }
    bufferPointer = 0;
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (message == null) {
      throw new IllegalArgumentException("Message cannot be null");
    }
    evictOutdatedAggregates(timestamp);
    if (isMessagedLogged(message)) {
      return false;
    }
    insertMessage(timestamp, message);
    return true;
  }

  private void evictOutdatedAggregates(int timestamp) {
    for (int i = 0; i < TIME_THRESHOLD; i++) {
      if (loggedMessages[i] != EMPTY_AGGREGATE && timestamp - loggedMessages[i].timestamp >= 10) {
        loggedMessages[i] = EMPTY_AGGREGATE;
      }
    }
  }

  private boolean isMessagedLogged(String message) {
    for (Aggregate aggregatedMessages : loggedMessages) {
      if (aggregatedMessages.messages.contains(message)) {
        return true;
      }
    }
    return false;
  }

  private void insertMessage(int timestamp, String message) {
    if (loggedMessages[bufferPointer] != EMPTY_AGGREGATE
        && loggedMessages[bufferPointer].timestamp == timestamp) {
      loggedMessages[bufferPointer].messages.add(message);
    } else {
      Set<String> messages = new HashSet<>();
      messages.add(message);
      bufferPointer = (bufferPointer + 1) % TIME_THRESHOLD;
      loggedMessages[bufferPointer] = new Aggregate(timestamp, messages);
    }
  }

  private record Aggregate(int timestamp, Set<String> messages) {}
}

/*
    There are many ways to think about it
    The simplest one is to keep Map<String, int> and check last message timestamp
    ... it will lead to memory overhead, but let's start simple
    Why it's bad? Because we keep a lot of messages we don't need
    Effectively it's memory leak, and we'll file with OOM
    ... we can Deque or ring buffer,
    let's start with Deque as there is build in java implementation

    first version:

    class Logger {

    private final Map<String, Integer> loggedMessages = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastLoggedTimestamp = loggedMessages.get(message);
        if (lastLoggedTimestamp == null || timestamp - lastLoggedTimestamp >= 10) {
            loggedMessages.put(message, timestamp);
            return true;
        }
        return false;
    }
}
*/
