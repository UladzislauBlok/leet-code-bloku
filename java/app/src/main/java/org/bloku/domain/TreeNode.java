package org.bloku.domain;

import java.util.Objects;

public class TreeNode {
  public Integer val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(Integer val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    TreeNode treeNode = (TreeNode) o;
    return Objects.equals(val, treeNode.val)
        && Objects.equals(left, treeNode.left)
        && Objects.equals(right, treeNode.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right);
  }
}
