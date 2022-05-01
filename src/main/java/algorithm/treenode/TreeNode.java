package algorithm.treenode;

/**
 * @author zhuwenxuan
 * @ClassName TreeNode
 * @date 2022/5/1 22:02
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}