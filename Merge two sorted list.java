/*You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify merging
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach the remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // The merged list starts at dummy.next
        return dummy.next;
    }
}
