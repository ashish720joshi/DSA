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
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode temp=head;
      ListNode prevLast=null;
      ListNode nextNode=null;
      while(temp!=null){
        ListNode kthNode=getKthNode(temp,k);

        if(kthNode==null){
            if(prevLast!=null)
            prevLast.next=temp;
            break;
         }

         nextNode=kthNode.next;
         kthNode.next=null;
        
         reverseLinkedList(temp);

         if(temp==head){
            head=kthNode;
         }else{
            prevLast.next=kthNode;
         }

         prevLast=temp;
         temp=nextNode;
      }

      return head;
    }

    private ListNode getKthNode(ListNode head,int k){
        ListNode temp=head;
        while(temp!=null && k>1){
            temp=temp.next;
            k--;
        }
        return temp;
    }

    private ListNode reverseLinkedList(ListNode head){
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