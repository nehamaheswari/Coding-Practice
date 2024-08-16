/*Given the head of a linked list, remove the nth node from the end of the list and return its head.*/

class ListNode {
    int val;
    ListNode next;
    ListNode() 
    {
    }
    ListNode(int val)
    {
      this.val = val; 
    }
    ListNode(int val, ListNode next)
    {
      this.val = val;
      this.next = next;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers, both starting at the dummy node
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move the fast pointer n+1 steps ahead so there's a gap of n between fast and slow
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Slow is now before the node to be deleted. Skip the node.
        slow.next = slow.next.next;
        
        // Return the head of the modified list
        return dummy.next;
    }
}
