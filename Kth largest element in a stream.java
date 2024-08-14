/*Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.*/

//TC: O(NLogK) and SC:O(K)

class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
  //heap: A PriorityQueue (min-heap) to keep track of the k largest elements encountered so far.
    final int k; ////k: The rank of the largest element we want to keep track of
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n : nums)
            add(n);

    }
    
    public int add(int val) {
        if(heap.size()<k) // If the heap contains fewer than k elements, just add the new value val to the heap.
            heap.offer(val);
        else if(val > heap.peek()) 
          //If the heap already contains k elements and val is greater than the smallest element in the heap
          //(i.e., the root of the min-heap), remove the smallest element (heap.poll()) and add val to the heap. 
          //This ensures that the heap always contains the k largest elements seen so far.
        {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek(); // After updating the heap, return the root of the min-heap, which represents the k-th largest element.
        
    }
}
