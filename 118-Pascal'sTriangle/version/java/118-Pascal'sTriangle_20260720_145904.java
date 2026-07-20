// Last updated: 20/07/2026, 14:59:04
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> generate(int numRows) {
6        List<List<Integer>> triangle = new ArrayList<>();
7
8        for (int i = 0; i < numRows; i++) {
9            List<Integer> row = new ArrayList<>();
10            
11            for (int j = 0; j <= i; j++) {
12           
13                if (j == 0 || j == i) {
14                    row.add(1);
15                } else {
16                    int num = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
17                    row.add(num);
18                }
19            }
20            
21            triangle.add(row);
22        }
23
24        return triangle;
25    }
26}