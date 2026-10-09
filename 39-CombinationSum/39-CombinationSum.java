// Last updated: 09/10/2026, 09:24:14
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort candidates to enable early pruning
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
            // Early pruning: if the current element is greater than the remainder, 
            // all subsequent elements will also be too large.
            if (candidates[i] > remain) {
                break;
            }

            current.add(candidates[i]);
            // Re-pass index 'i' to allow the same element to be chosen multiple times
            backtrack(result, current, candidates, remain - candidates[i], i);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}