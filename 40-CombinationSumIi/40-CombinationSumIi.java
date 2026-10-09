// Last updated: 09/10/2026, 09:24:11
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to easily handle duplicates and enable early pruning
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early pruning: since the array is sorted, if the element exceeds the remainder, subsequent elements will too
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate elements at the same decision level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            // Move to next index since each element can only be used once
            backtrack(result, current, candidates, remain - candidates[i], i + 1);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}