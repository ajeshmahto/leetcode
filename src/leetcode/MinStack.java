package leetcode;

import java.util.Stack;

class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(10);
        minStack.push(3);
        minStack.push(15);
        minStack.push(12);
        minStack.push(11);
        minStack.push(1);
        minStack.push(18);
        minStack.push(10);

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
