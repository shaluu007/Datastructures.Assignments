package Stack;

import java.util.EmptyStackException;

public class StackExmp {
    private int[] elements;
    private int top;
    private int capacity;

    public StackExmp(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
        this.top = -1;
    }

    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow: Cannot push element. Stack is full.");
        } else {
            elements[++top] = element;
            System.out.println("Pushed element: " + element);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            int element = elements[top--];
            return element;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return elements[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackExmp stack = new StackExmp(5); 

        stack.push(15);
        stack.push(45);
        stack.push(92);
        

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());
        System.out.println("Top element after pop: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
        try {
            System.out.println("Popped element: " + stack.pop());
        } catch (EmptyStackException e) {
            System.out.println("Cannot pop from empty stack.");
        }
    }
}

