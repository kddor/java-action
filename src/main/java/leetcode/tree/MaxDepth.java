package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by apple on 2019/7/2.
 * 给定一个二叉树，找出其最大深度。
 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。
 *
 *
 */
public class MaxDepth {
    /**
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        int maxdepth=0;
        while (root.left!=null||root.right!=null){
            maxdepth+=1;
            root=root.left;
            root=root.right;
        }
        return maxdepth;
    }

    /**
     * 递归（自顶向下）
     */
    private int maxDepth;

    public int maxDepth1(TreeNode root) {
        topDown(root, 0);
        return maxDepth;
    }

    private void topDown(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = depth > maxDepth ? depth : maxDepth;
            return;
        }
        topDown(node.left, depth + 1);
        topDown(node.right, depth + 1);
    }

    /**
     * 递归（自底向上）
     */
    public int maxDepth2(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    /**
     * 迭代
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode n = queue.remove();
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }
        return level;
    }
}


