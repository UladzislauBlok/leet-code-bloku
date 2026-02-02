package org.bloku.task._166;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Fraction to Recurring Decimal")
@Topics({MATH, STRING, HASH_TABLE})
class Solution {

  // Math thing
  // long division
  public String fractionToDecimal1(int numerator, int denominator) {
    if (numerator == 0) return "0";
    long numer = numerator;
    long denor = denominator;
    boolean negative = false;
    if (numer < 0) {
      negative = !negative;
      numer *= -1;
    }
    if (denor < 0) {
      negative = !negative;
      denor *= -1;
    }
    Map<Long, Integer> map = new HashMap<>();
    long num = numer / denor;
    StringBuilder sb = new StringBuilder(".");
    long dec = numer % denor;
    if (dec == 0) return (negative ? "-" : "") + num;
    int pos = 1; // 0 is .
    while (dec != 0) {
      if (map.containsKey(dec)) {
        return (negative ? "-" : "")
            + num
            + sb.substring(0, map.get(dec))
            + "("
            + sb.substring(map.get(dec))
            + ")";
      }
      map.put(dec, pos++);
      dec *= 10;
      sb.append(dec / denor);
      dec %= denor;
    }
    return (negative ? "-" : "") + num + sb.toString();
  }

  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";
    StringBuilder sb = new StringBuilder();
    if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);
    sb.append(num / den);
    long rem = num % den;
    if (rem == 0) return sb.toString();
    sb.append(".");
    Map<Long, Integer> map = new HashMap<>();
    while (rem != 0) {
      if (map.containsKey(rem)) {
        sb.insert(map.get(rem), "(");
        sb.append(")");
        break;
      }
      map.put(rem, sb.length());
      rem *= 10;
      sb.append(rem / den);
      rem %= den;
    }
    return sb.toString();
  }
}
