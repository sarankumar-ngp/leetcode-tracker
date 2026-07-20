// Last updated: 20/07/2026, 15:24:32
1import java.util.LinkedList;
2import java.util.Queue;
3
4class MyStack {
5    private Queue<Integer> queue;
6
7    public MyStack() {
8        queue = new LinkedList<>();
9    }
10    
11    // O(n) time: Rotate the queue to make the new element the head
12    public void push(int x) {
13        queue.add(x);
14        int size = queue.size();
15        
16        // Rotate the previous elements to the back of the queue
17        for (int i = 0; i < size - 1; i++) {
18            queue.add(queue.remove());
19        }
20    }
21    
22    // O(1) time
23    public int pop() {
24        return queue.remove();
25    }
26    
27    // O(1) time
28    public int top() {
29        return queue.peek();
30    }
31    
32    // O(1) time
33    public boolean empty() {
34        return queue.isEmpty();
35    }
36}
37
38/**
39 * Your MyStack object will be instantiated and called as such:
40 * MyStack obj = new MyStack();
41 * obj.push(x);
42 * int param_2 = obj.pop();
43 * int param_3 = obj.top();
44 * boolean param_4 = obj.empty();
45 */