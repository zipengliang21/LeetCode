package Easy;

class MyQueue {

    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private int peekValue;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
        peekValue = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            peekValue = x;
        }
        s1.push(x);
    }

    public int pop() {
        shiftStack();
        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            return peekValue;
        }
        return s2.peek();
    }

    private void shiftStack() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
