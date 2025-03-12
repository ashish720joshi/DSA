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
    int ans=-1;
    int count=1;
    public int kthSmallest(TreeNode root, int k) {
       if(root==null) return ans;
        kthSmallest(root.left,k);
        if(k==count && ans==-1){
            ans=root.val;
            return ans;
        }
        count++;
        kthSmallest(root.right,k);
        return ans;
    }
}


// optimized solution below


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int count = 0; 

    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = helper(root, k);
        return result != null ? result.val : 0; 
    }

    private TreeNode helper(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode left = helper(root.left, k);
        if (left != null) return left; // If found in left subtree, won't do unnecessary compuations further of right tree
        count++; 
        if (count == k) return root;
        return helper(root.right, k);
    }
}