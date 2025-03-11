/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node>map=new HashMap<>();
        Node copyHead=null;
        Node initial=new Node(0);
        initial.next=head;
        Node prev=null;
        Node curr=initial;
        Node newNode=null;
        while(curr!=null){
            if(map.containsKey(curr)){
                newNode=map.get(curr);
            }else{
                newNode=new Node(curr.val);
                map.put(curr,newNode);
            }

                if(curr.random!=null){
                    if(map.containsKey(curr.random)){
                        newNode.random=map.get(curr.random);
                    }else{
                        newNode.random=new Node(curr.random.val);
                        map.put(curr.random,newNode.random);
                    }
                }

                if(prev!=null) prev.next=newNode;
                
                prev=newNode;
                curr=curr.next;
            }
        return map.get(initial).next;
    }
}