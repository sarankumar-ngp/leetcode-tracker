// Last updated: 20/07/2026, 15:17:24
1class Solution {
2    public boolean isHappy(int n) {
3        int slow = n;
4        int fast = n;
5
6        do {
7            slow = getNext(slow);      
8            fast = getNext(getNext(fast)); 
9        } while (slow != fast);
10        return slow == 1;
11    }
12
13    private int getNext(int n) {
14        int totalSum = 0;
15        while (n > 0) {
16            int digit = n % 10;
17            totalSum += digit * digit;
18            n /= 10;
19        }
20        return totalSum;
21    }
22}