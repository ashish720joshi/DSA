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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>res=new ArrayList<>();
        List<List<Integer>>list=new ArrayList<>();
        traverseBFS(root,0,list);
        for(int i=0;i<list.size();i++){
            double sum=0.00000;
            for(int a:list.get(i)){
                sum+=a;
            }
            res.add(sum/list.get(i).size());
        }
        return res;
    }

    private void traverseBFS(TreeNode root,int currentLevel,
    List<List<Integer>>list){
        if(root==null) return;
        if(list.size()<=currentLevel){
            list.add(new ArrayList<>());
        }
        list.get(currentLevel).add(root.val);
        traverseBFS(root.left,currentLevel+1,list);
        traverseBFS(root.right,currentLevel+1,list);
    }
}

// BFS using QUEUE


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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return null;
        List<Double>res=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            double sum=0.00000;
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node!=null){
                   if(node.left!=null) queue.offer(node.left);
                   if(node.right!=null) queue.offer(node.right);
                }
            }
            res.add(sum/n);
        }
        return res;
    }
}