package BinarySearchTreetoGreaterSumTree;

public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    // rightSum + root 하위 노드들의 합을 반환
    public int dfs(TreeNode root, int rightSum){
        if(root == null)    return rightSum;

        // root의 오른쪽 노드들의 합
        int newRightSum = dfs(root.right, rightSum);

        // root <- root + rightSum
        root.val += newRightSum;

        // root.val 값을 포함한 root의 왼쪽 노드들의 합
        int leftSum = dfs(root.left, root.val);

        return leftSum;
    }

    /*
    // right 합계를 반환한다.
    public int dfs(TreeNode root){
        // root의 오른쪽 합
        int rightSum = 0;
        if(root.right != null){
            rightSum = dfs(root.right);
            // root.right.val += rightSum;
        }

        // root <- root + 오른쪽합
        root.val += rightSum;

        // left <- left + root
        int leftSum = 0;
        if(root.left != null){
            leftSum += dfs(root.left);
            root.left.val = root.val + leftSum;
        }

        // left의 값: root 아래 노드들의 original key의 합
        return root.val + leftSum;
    }
     */

    public static void main(String[] args) {

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
}
