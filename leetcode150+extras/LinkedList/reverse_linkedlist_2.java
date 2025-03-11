/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        int index=1;
        ListNode leftNode,rightNode=null;
        while(index<left){
            curr=curr.next;
            index++;
        }
        leftNode=curr;
        while(index<=right){
            curr=curr.next;
            index++;
        }
        rightNode=curr.next;
        curr.next=null;
        ListNode newHead=leftNode.next;
        newHead=reverseLinkedList(newHead);
        leftNode.next=newHead;
        curr=newHead;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=rightNode;
        return dummy.next;
    }

    public ListNode reverseLinkedList(ListNode newHead){
        ListNode first=newHead;
        ListNode second=newHead;
        ListNode temp=null;
        while(first.next!=null){
            second=second.next;
            first.next=temp;
            temp=first;
            first=second;
        }
        second.next=temp;
        newHead=second;
        return newHead;
    }
}