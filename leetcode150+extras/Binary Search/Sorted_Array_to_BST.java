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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start=0,end=nums.length-1;
        return createSubTree(start,end,nums);
        
    }
    private TreeNode createSubTree(int start,int end,int []nums){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=createSubTree(start,mid-1,nums);
        root.right=createSubTree(mid+1,end,nums);
        return root;
    }
}