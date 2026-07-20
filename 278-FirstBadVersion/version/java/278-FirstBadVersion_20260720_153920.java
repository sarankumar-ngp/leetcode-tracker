// Last updated: 20/07/2026, 15:39:20
1/* The isBadVersion API is defined in the parent class VersionControl.
2   boolean isBadVersion(int version); */
3
4public class Solution extends VersionControl {
5    public int firstBadVersion(int n) {
6        int left = 1;
7        int right = n;
8        
9        while (left < right) {
10            // Avoid integer overflow that happens with (left + right) / 2
11            int mid = left + (right - left) / 2;
12            
13            if (isBadVersion(mid)) {
14                // If mid is bad, the first bad version is either mid or to its left
15                right = mid;
16            } else {
17                // If mid is good, the first bad version must be strictly to its right
18                left = mid + 1;
19            }
20        }
21        
22        // When left == right, we've converged on the first bad version
23        return left;
24    }
25}