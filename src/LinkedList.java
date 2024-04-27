import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> {

    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(T element) {
        Node<T> current = head;
        Node<T> prev = null;
        if (current != null && current.data.equals(element)) {
            head = current.next; // Changed head
            return;
        }
        while (current != null && !current.data.equals(element)) {
            prev = current;
            current = current.next;
        }
        if (current == null)
            return;

        prev.next = current.next;
    }

    public int countNodes() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

}
