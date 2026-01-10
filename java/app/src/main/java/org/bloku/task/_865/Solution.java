package org.bloku.task._865;

import static org.bloku.util.Topic.*;

import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Smallest Subtree with all the Deepest Nodes")
@Topics({TREE, BINARY_TREE, DFS})
class Solution {

    private final int[] map = new int[500];

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        find(root, 0);
        return split(root);
    }

    private int find(TreeNode root, int lvl) {
        if (root == null) return lvl;
        int max = find(root.left, lvl + 1);
        max = Math.max(max, find(root.right, lvl + 1));
        map[root.val] = max;
        return max;
    }

    private TreeNode split(TreeNode root) {
        int left = root.left != null ? map[root.left.val] : -1;
        int right = root.right != null ? map[root.right.val] : -1;
        if (left == right) return root;
        if (left > right) return split(root.left);
        return split(root.right);
    }
}
