/*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.*/

//TC: O(n)
//SC: O(1)
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate the current area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;
            
            // Update maxArea if the currentArea is larger
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(height);
        System.out.println(result);  // Expected Output: 49
    }
}
