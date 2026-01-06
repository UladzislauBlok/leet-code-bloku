package org.bloku.task._1161;

import static org.bloku.util.Topic.*;

import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayDeque;
import java.util.Queue;

@LeetCodeName("Maximum Level Sum of a Binary Tree")
@Topics({TREE, QUEUE, BINARY_TREE})
class Solution {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int res = 0, lvl = 0, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size(); // lvl size
            lvl++;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (sum > max) {
                max = sum;
                res = lvl;
            }
        }
        return res;
    }
}
