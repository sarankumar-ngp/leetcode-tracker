// Last updated: 28/07/2026, 15:43:37
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // O(n) time: Rotate the queue to make the new element the head
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        
        // Rotate the previous elements to the back of the queue
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    // O(1) time
    public int pop() {
        return queue.remove();
    }
    
    // O(1) time
    public int top() {
        return queue.peek();
    }
    
    // O(1) time
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */