public class LinkedList {

    public static class Node {
        Student student;
        Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    Node head;

    public void add(Student student) {
        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int id) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.student.getID() == id) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("STUDENT ID => " + current.student.getID());
            System.out.println("STUDENT NAME => " + current.student.getName());
            System.out.println();
            current = current.next;
        }
    }

    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

}
