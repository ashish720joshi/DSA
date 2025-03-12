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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>>res=new ArrayList<>();
         if(root==null) return res;
         Deque<TreeNode>queue=new LinkedList<>();
         boolean leftToRight=true;
         queue.add(root);
         while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer>list=new ArrayList<>();
            TreeNode node=null;
            for(int i=0;i<n;i++){
                 if(leftToRight){
                node=queue.pollFirst();
                if(node.left!=null) queue.offerLast(node.left);
                if(node.right!=null) queue.offerLast(node.right);
            }else{
                node=queue.pollLast();
                if(node.right!=null) queue.offerFirst(node.right);
                if(node.left!=null) queue.offerFirst(node.left);
            }
                list.add(node.val);
            }
            leftToRight=!leftToRight;
            res.add(list);
         }
         return res;
    }
}