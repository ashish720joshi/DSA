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
class BSTIterator {
    private TreeNode node;
    private BSTIterator next;
    private BSTIterator bstIterator;
    
    public BSTIterator(){}

    public BSTIterator(TreeNode root) {
        bstIterator=new BSTIterator();
        BSTIterator dummy=bstIterator;
        bstIterator.node=new TreeNode(Integer.MIN_VALUE,null,null);
        setInOrderTraversal(root);
        bstIterator=dummy;
    }
    
    public int next() {
        TreeNode node=null;
        if(bstIterator.next!=null){
            node=bstIterator.next.node;
            bstIterator=bstIterator.next;
        }
        return node!=null?node.val:-1;
    }
    
    public boolean hasNext() {
        if(bstIterator==null) return false;
        return bstIterator.next!=null?true:false;
    }

    private void setInOrderTraversal(TreeNode root){
        if(root==null) return;
        if(root.left!=null) setInOrderTraversal(root.left);
        TreeNode node=new TreeNode(root.val,root.left,root.right);
        BSTIterator bstIteratorNode=new BSTIterator();
        bstIteratorNode.node=node;
        bstIterator.next=bstIteratorNode;
        bstIterator=bstIterator.next;
        if(root.right!=null) setInOrderTraversal(root.right);
    }
}

// below code is optimized


class BSTIterator {
    Stack<TreeNode>stack;

    public BSTIterator(TreeNode root) {
      stack=new Stack<>();
      pushLeft(root);
    }

    private void pushLeft(TreeNode node){
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
    
    public int next() {
        TreeNode node=stack.pop();
        pushLeft(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
       return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */