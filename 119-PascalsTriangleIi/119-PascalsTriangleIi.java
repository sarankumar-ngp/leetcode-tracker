// Last updated: 28/07/2026, 15:44:19
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long current = 1; 
        row.add((int) current);

        for (int j = 1; j <= rowIndex; j++) {
            current = current * (rowIndex - j + 1) / j;
            row.add((int) current);
        }

        return row;
    }
}