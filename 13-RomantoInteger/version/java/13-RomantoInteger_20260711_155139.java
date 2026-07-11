// Last updated: 11/07/2026, 15:51:39
1import java.util.HashMap;
2
3class Solution {
4    public int romanToInt(String s) {
5
6        HashMap<Character, Integer> map = new HashMap<>();
7
8        map.put('I', 1);
9        map.put('V', 5);
10        map.put('X', 10);
11        map.put('L', 50);
12        map.put('C', 100);
13        map.put('D', 500);
14        map.put('M', 1000);
15
16        int result = 0;
17
18        for (int i = 0; i < s.length(); i++) {
19
20            int current = map.get(s.charAt(i));
21
22            if (i < s.length() - 1 && current < map.get(s.charAt(i + 1))) {
23                result -= current;
24            } else {
25                result += current;
26            }
27        }
28
29        return result;
30    }
31}