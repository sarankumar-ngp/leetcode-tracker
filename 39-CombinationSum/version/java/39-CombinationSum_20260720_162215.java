// Last updated: 20/07/2026, 16:22:15
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> combinationSum(int[] candidates, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        // Sort candidates to enable early pruning
9        Arrays.sort(candidates);
10        backtrack(result, new ArrayList<>(), candidates, target, 0);
11        return result;
12    }
13
14    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
15        if (remain == 0) {
16            result.add(new ArrayList<>(current));
17            return;
18        }
19
20        for (int i = start; i < candidates.length; i++) {
21            // Early pruning: if the current element is greater than the remainder, 
22            // all subsequent elements will also be too large.
23            if (candidates[i] > remain) {
24                break;
25            }
26
27            current.add(candidates[i]);
28            // Re-pass index 'i' to allow the same element to be chosen multiple times
29            backtrack(result, current, candidates, remain - candidates[i], i);
30            current.remove(current.size() - 1); // Backtrack
31        }
32    }
33}