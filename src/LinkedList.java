import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;

    public void append(T element) {
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

    public void print() {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element instanceof Student) {
                printStudentDetails((Student) element);
            } else {
                System.out.println("Error: Element is not an instance of Student");
            }
        }
    }

    private void printStudentDetails(Student student) {
        String line = "+-------------------------------+%n";
        // Printing out headings
        System.out.println("\n\n");
        System.out.printf(line);
        System.out.printf("| %-29s |%n", "STUDENT CARD");
        System.out.printf(line);
        System.out.printf("| %-15s | %-11s |%n", "STUDENT NAME", student.getName());
        System.out.printf("| %-15s | %-11s |%n", "STUDENT ID", student.getID());
        System.out.printf("| %-15s | %-11s |%n", "STUDENT COURSE", student.getCourse());
        System.out.printf(line);

    }

    public boolean isEmpty() {
        return head == null;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    // Was changed due to project requirements
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
