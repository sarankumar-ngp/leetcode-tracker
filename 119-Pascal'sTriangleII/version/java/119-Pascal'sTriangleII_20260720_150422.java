// Last updated: 20/07/2026, 15:04:22
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> getRow(int rowIndex) {
6        List<Integer> row = new ArrayList<>();
7        long current = 1; 
8        row.add((int) current);
9
10        for (int j = 1; j <= rowIndex; j++) {
11            current = current * (rowIndex - j + 1) / j;
12            row.add((int) current);
13        }
14
15        return row;
16    }
17}