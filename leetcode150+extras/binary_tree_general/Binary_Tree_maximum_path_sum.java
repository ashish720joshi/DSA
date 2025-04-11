/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int maximum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int max=maxPathSumTree(root);
        return Math.max(maximum,max);
    }

    private int maxPathSumTree(TreeNode root){
       if(root==null) return 0;
       int maxLeftPath=Math.max(maxPathSumTree(root.left),0);
       int maxRightPath=Math.max(maxPathSumTree(root.right),0);
       maximum=Math.max(maximum,root.val+maxLeftPath+maxRightPath);
       return root.val+Math.max(maxLeftPath,maxRightPath);
    }
}