package main.StackAndQueue;

/**
 * First In First Out
 */
public class Queue<T> {
    QueueNode<T> first;
    QueueNode<T> last;

    class QueueNode<T> {
        T data;
        QueueNode next;

        private QueueNode(T data) {
            this.data = data;

        }
    }

    public Queue() {}


    public void add(T data) {
        QueueNode item = new QueueNode(data);
        if(first == null && last == null) {
            first = last = item;
            return;
        }
        last.next = item;
        last = item;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) return  null;
        if(first == last) {
            T t = (T)first.data;
            first = last = null;
            return t;
        }
        QueueNode t = first;
        first = first.next;
        return (T)t.data;
    }

    public boolean isEmpty() {
        return first == null ? true: false;
    }

    public T peek() {
        return first.data;
    }
}
