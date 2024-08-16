/*You are given m arrays, where each array is sorted in ascending order.
You can pick up two integers from two different arrays (each array picks one) and calculate the distance. 
We define the distance between two integers a and b to be their absolute difference |a - b|.
Return the maximum distance.*/

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
      // Initialize min and max with the first array's first and last elements
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        
        // Track the maximum distance
        int maxDistance = 0;
        
        // Iterate over the remaining arrays
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
          //currentFirst: The first element of the current array.
          //currentLast: The last element of the current array.
            int currentFirst = currentArray.get(0);
            int currentLast = currentArray.get(currentArray.size() - 1);
            
            // Compute the maximum distance possible with the current array
            maxDistance = Math.max(maxDistance, Math.abs(currentLast - min));
            maxDistance = Math.max(maxDistance, Math.abs(max - currentFirst));
            
            // Update min and max with the current array's first and last elements
            min = Math.min(min, currentFirst);
            max = Math.max(max, currentLast);
        }
        
        return maxDistance;
    }
}
