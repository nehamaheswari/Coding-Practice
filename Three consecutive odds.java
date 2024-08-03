class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // Iterate through the array, stopping 2 elements before the end
        for (int i = 0; i < arr.length - 2; i++) {
            // Check if the current element and the next two are all odd
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        // If no such sequence is found, return false
        return false;
    }
}
