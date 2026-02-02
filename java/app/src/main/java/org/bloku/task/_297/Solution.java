package org.bloku.task._297;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Serialize and Deserialize Binary Tree")
@Topics({TREE, STRING, DFS})
class Solution {

  private static final TreeNode NULL_NODE = new TreeNode(Integer.MIN_VALUE);

  // Encodes a tree to a single string.
  public String serializeLvlByLvl(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root != null ? root : NULL_NODE);
    while (!queue.isEmpty()) {
      int lvl = queue.size();
      for (int i = 0; i < lvl; i++) {
        TreeNode node = queue.poll();
        if (node == NULL_NODE) { // check by ref
          sb.append("N");
        } else {
          sb.append(node.val);
          queue.add(node.left != null ? node.left : NULL_NODE);
          queue.add(node.right != null ? node.right : NULL_NODE);
        }
        sb.append(";");
      }
      sb.setCharAt(sb.length() - 1, '|');
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserializeLvlByLvl(String data) {
    if (data.equals("N")) return null;
    String[] parsed = data.split("\\|");
    TreeNode root = new TreeNode(Integer.parseInt(parsed[0]));
    List<TreeNode> line = new ArrayList<>();
    line.add(root);
    for (int i = 1; i < parsed.length; i++) {
      List<TreeNode> newLine = new ArrayList<>();
      String[] values = parsed[i].split(";");
      for (int j = 0; j < values.length; j++) {
        if (values[j].equals("N")) continue;
        TreeNode node = new TreeNode(Integer.parseInt(values[j]));
        TreeNode parent = line.get(j / 2);
        if ((j & 1) == 0) {
          parent.left = node;
        } else {
          parent.right = node;
        }
        newLine.add(node);
      }
      line = newLine;
    }
    return root;
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();

    s(root, sb);

    return sb.toString();
  }

  private void s(TreeNode rt, StringBuilder sb) {
    if (rt == null) {
      sb.append("#");
      return;
    }

    sb.append(rt.val).append(".");
    s(rt.left, sb);
    s(rt.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    AtomicInteger idx = new AtomicInteger(0);

    TreeNode ans = d(data, idx);

    return ans;
  }

  private TreeNode d(String dt, AtomicInteger idx) {
    if (idx.get() >= dt.length() || dt.charAt(idx.get()) == '#') {
      idx.getAndIncrement();
      return null;
    }

    TreeNode cur = new TreeNode(number(dt, idx));

    idx.getAndIncrement();

    cur.left = d(dt, idx);
    cur.right = d(dt, idx);

    return cur;
  }

  private int number(String dt, AtomicInteger idx) {
    StringBuilder sb = new StringBuilder();

    while (idx.get() < dt.length() && dt.charAt(idx.get()) != '.' && dt.charAt(idx.get()) != '#') {
      sb.append(dt.charAt(idx.getAndIncrement()));
    }

    return Integer.valueOf(sb.toString());
  }
}
