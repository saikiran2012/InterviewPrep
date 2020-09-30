package main.StackAndQueue;

/**
 * Last in first out;
 */
public class Stack<T> {
    private T data;
    private Stack<T> next;
    private Stack<T> top;

    public Stack() {}

    private Stack(T data) {
        this.data = data;
        this.next = null;
    }

    public boolean isEmpty() {
        return top == null ? true : false;
    }

    public T pop() {
        if(top == null) return null;
        Stack<T> t = top;
        top = top.next;
        return t.data;
    }

    public void push(T data) {
        Stack<T> item = new Stack(data);
        Stack<T> t = top;
        item.next = t;
        top = item;
    }

    public T peek() {
        if(top == null) return null;
        return top.data;
    }
}
