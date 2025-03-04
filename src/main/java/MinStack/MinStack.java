package MinStack;

import java.util.Stack;

// https://neetcode.io/problems/minimum-stack

public class MinStack {
    private Stack<Integer> stiva;
    private Integer minValue;

    public MinStack() {
        stiva = new Stack<>();
    }

    public void push(int val) {
        stiva.push(val);
        if(stiva.size() == 1) minValue= val;
        else minValue = Math.min(val, minValue);
        stiva.push(minValue);
    }

    public void pop() {
        stiva.pop();
        stiva.pop();
        minValue = !stiva.empty()? stiva.peek() : null;
    }

    public int top() {
        return stiva.get(stiva.size()-2);
    }

    public int getMin() {
        return stiva.peek();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MinStack{");
        sb.append("list=").append(stiva);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.pop();
        minStack.push(20);
        System.out.println(minStack.top());
        minStack.push(-20);
        System.out.println(minStack.getMin());
    }
}
