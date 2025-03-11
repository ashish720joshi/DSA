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
    public ListNode reverseList(ListNode head) {
        ListNode first=head;
        ListNode second=head;
        ListNode temp=null;
        if(head!=null){
        while(second.next!=null){
            second=second.next;
            first.next=temp;
            temp=first;
            first=second;
        }
        second.next=temp;
        head=second;
        }
        return head;
    }
}