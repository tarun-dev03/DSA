/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int lengthOfCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                ListNode temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }
        return 0;
    }
    public ListNode detectCycle(ListNode head) {
        int length = lengthOfCycle(head);
        ListNode first = head;
        ListNode second = head;
        if(length == 0){
            return null;
        }
        while(length > 0){
            second = second.next;
            length--;
        }
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
        
    }
}