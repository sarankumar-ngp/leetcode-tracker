// Last updated: 11/07/2026, 15:54:19
1import java.util.Stack;
2
3class Solution {
4    public boolean isValid(String s) {
5
6        Stack<Character> stack = new Stack<>();
7
8        for (char ch : s.toCharArray()) {
9
10            if (ch == '(' || ch == '{' || ch == '[') {
11                stack.push(ch);
12            } else {
13
14                if (stack.isEmpty()) {
15                    return false;
16                }
17
18                char top = stack.pop();
19
20                if ((ch == ')' && top != '(') ||
21                    (ch == '}' && top != '{') ||
22                    (ch == ']' && top != '[')) {
23                    return false;
24                }
25            }
26        }
27
28        return stack.isEmpty();
29    }
30}