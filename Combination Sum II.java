/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate numbers
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            // If the number is greater than the target, no need to proceed further
            if (candidates[i] > target) break;
            tempList.add(candidates[i]);
            // Recurse with updated target and start index
            backtrack(result, tempList, candidates, target - candidates[i], i + 1);
            // Remove the last number to try the next candidate
            tempList.remove(tempList.size() - 1);
        }
    }
}
