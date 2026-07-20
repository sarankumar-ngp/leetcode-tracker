// Last updated: 20/07/2026, 16:16:38
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        // Sort to easily handle duplicates and enable early pruning
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
21            // Early pruning: since the array is sorted, if the element exceeds the remainder, subsequent elements will too
22            if (candidates[i] > remain) {
23                break;
24            }
25
26            // Skip duplicate elements at the same decision level
27            if (i > start && candidates[i] == candidates[i - 1]) {
28                continue;
29            }
30
31            current.add(candidates[i]);
32            // Move to next index since each element can only be used once
33            backtrack(result, current, candidates, remain - candidates[i], i + 1);
34            current.remove(current.size() - 1); // Backtrack
35        }
36    }
37}