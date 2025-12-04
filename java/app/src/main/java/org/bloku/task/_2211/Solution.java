package org.bloku.task._2211;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayDeque;
import java.util.Deque;

@LeetCodeName("Count Collisions on a Road")
@Topics({STRING, ARRAY, STACK, SIMULATION})
class Solution {
    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        int n = chars.length;
        int res = 0;
        int left = 0, right = n - 1;
        while (left < n && chars[left] == 'L') left++;
        if (left == n) return 0;
        while (right >= 0 && chars[right] == 'R') right--;
        if (right == -1) return 0;
        for (int i = left; i <= right; i++) {
            if (chars[i] != 'S') res++;
        }
        return res;
    }

    public int countCollisionsMonotonicStack(String directions) {
        char[] stack = new char[directions.length()];
        int pos = -1;
        int res = 0;
        for (char c : directions.toCharArray()) {
            if (c == 'R') {
                pos++;
                stack[pos] = 'R';
            } else if (c == 'S') {
                while (pos >= 0 && stack[pos] == 'R') {
                    res++;
                    pos--;
                }
                pos++;
                stack[pos] = 'S';
            } else {
                boolean wasEmpty = pos == -1;
                if (pos >= 0) {
                    res += stack[pos] == 'R' ? 2 : 1;
                    pos--;
                }
                while (pos >= 0 && stack[pos] == 'R') {
                    res++;
                    pos--;
                }
                if (!wasEmpty) {
                    pos++;
                    stack[pos] = 'S';
                }
            }
        }
        return res;
    }

    public int countCollisionsDeque(String directions) {
        Deque<Character> stack = new ArrayDeque<>();
        int res = 0;
        for (char c : directions.toCharArray()) {
            if (c == 'R') {
                stack.push(c);
            } else if (c == 'S') {
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    res++;
                    stack.pop();
                }
                stack.push(c);
            } else {
                boolean wasEmpty = stack.isEmpty();
                if (!stack.isEmpty()) {
                    res += stack.peek() == 'R' ? 2 : 1;
                    stack.pop();
                }
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    res++;
                    stack.pop();
                }
                if (!wasEmpty) stack.push('S');
            }
        }
        return res;
    }

    /*
        Looks like standart stack problem
        R -> put into stack
        S -> get all R from the stack, put into stack after
        L -> {
            if stack is empty -> do nothing
            if stack has R on top -> res += 2, and perform check for R in stack
            if stack has S on top -> res += 1, and perform check for R in stack
        }
    */
}
