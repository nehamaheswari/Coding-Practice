//Given the head of a singly linked list, reverse the list, and return the reversed list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val)
        {
         this.val = val;
        }
 *     ListNode(int val, ListNode next) 
        { 
         this.val = val; 
         this.next = next; 
        }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;  // Save the next node
            current.next = prev;  // Reverse the current node's pointer
            prev = current;       // Move prev and current one step forward
            current = next;
        }

        return prev;  // New head of the reversed list
    }
}
