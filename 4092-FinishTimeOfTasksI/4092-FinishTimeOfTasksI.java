// Last updated: 09/07/2026, 10:13:36
import java.util.*;

class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {

        Object[] torqavemi = {n, edges, baseTime};

        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
        }

        long[] finish = new long[n];

        int[] order = new int[n];
        int idx = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            order[idx++] = node;

            for (int child : tree[node]) {
                stack.push(child);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int node = order[i];

            if (tree[node].isEmpty()) {
                finish[node] = baseTime[node];
            } else {
                long earliest = Long.MAX_VALUE;
                long latest = Long.MIN_VALUE;

                for (int child : tree[node]) {
                    earliest = Math.min(earliest, finish[child]);
                    latest = Math.max(latest, finish[child]);
                }

                finish[node] =
                        latest + (latest - earliest) + baseTime[node];
            }
        }

        return finish[0];
    }
}