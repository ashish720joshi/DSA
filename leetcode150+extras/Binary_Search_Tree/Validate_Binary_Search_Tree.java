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
    long lastVal=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecur(root)!=null?false:true;
    }

    private TreeNode isValidBSTRecur(TreeNode root){
        if(root==null) return null;
        TreeNode leftSubTree=isValidBSTRecur(root.left);
        if(leftSubTree!=null) return leftSubTree;
        if(lastVal<root.val){
           lastVal=root.val;
        }else return root;
        return isValidBSTRecur(root.right);
    }
}