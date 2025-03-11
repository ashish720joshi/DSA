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
    public ListNode partition(ListNode head, int x) {
        ListNode lesser=new ListNode(0);
        ListNode greater=new ListNode(0);
        ListNode newHead=lesser;
        ListNode mid=greater;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                lesser.next=new ListNode(curr.val);
                lesser=lesser.next;
            }else{
                 greater.next=new ListNode(curr.val);
                 greater=greater.next;
            }
            curr=curr.next;
        }
        lesser.next=mid.next;
        return newHead.next;
    }
}