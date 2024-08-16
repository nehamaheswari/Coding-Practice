/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.*/

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
      this.val = val;
    }
    ListNode(int val, ListNode next) { 
      this.val = val;
      this.next = next;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to keep track of the smallest elements
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        
        // Dummy node to help with building the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // While the heap is not empty
        while (!minHeap.isEmpty()) {
            // Extract the node with the smallest value
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;
            
            // If there's a next node, add it to the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        // Return the merged list starting at dummy.next
        return dummy.next;
    }
}
