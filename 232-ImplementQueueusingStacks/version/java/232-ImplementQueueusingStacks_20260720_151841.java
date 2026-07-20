// Last updated: 20/07/2026, 15:18:41
1import java.util.Stack;
2
3class MyQueue {
4    private Stack<Integer> inputStack;
5    private Stack<Integer> outputStack;
6
7    public MyQueue() {
8        inputStack = new Stack<>();
9        outputStack = new Stack<>();
10    }
11    
12    public void push(int x) {
13        inputStack.push(x);
14    }
15    
16    public int pop() {
17        shiftStacks();
18        return outputStack.pop();
19    }
20    
21    public int peek() {
22        shiftStacks();
23        return outputStack.peek();
24    }
25    
26    public boolean empty() {
27        return inputStack.isEmpty() && outputStack.isEmpty();
28    }
29
30
31    private void shiftStacks() {
32        if (outputStack.isEmpty()) {
33            while (!inputStack.isEmpty()) {
34                outputStack.push(inputStack.pop());
35            }
36        }
37    }
38}
39