class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        calculateCombinationSum(new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    private void calculateCombinationSum(List<Integer> combination, int[] candidates, int target, int combinationSum, int start) {
        if (combinationSum > target) return; // Prune invalid path
        if (combinationSum == target) {      // Valid combination
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]); // Choose
            calculateCombinationSum(combination, candidates, target, combinationSum + candidates[i], i); // Explore
            combination.remove(combination.size() - 1); // Backtrack
        }
    }
}
