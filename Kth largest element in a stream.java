class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n : nums)
            add(n);

    }
    
    public int add(int val) {
        if(heap.size()<k)
            heap.offer(val);
        else if(val > heap.peek())
        {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();    
        
    }
}
