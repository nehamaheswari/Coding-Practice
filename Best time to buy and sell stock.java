/*You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*/
//TC: O(n)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        // Handle edge case for empty array
        if (prices.length == 0) return 0;
        
        // Initialize variables
      //minPrice: Set to a very large value initially (use Integer.MAX_VALUE), which will be updated as you find lower prices.
      //maxProfit: Initialized to 0 to store the maximum profit.
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // Iterate through the array
        for (int price : prices) {
            // Update minPrice to be the lowest price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            
            // Calculate profit if we sell at the current price
            int profit = price - minPrice;
            
            // Update maxProfit if the current profit is greater
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
    
   
}
