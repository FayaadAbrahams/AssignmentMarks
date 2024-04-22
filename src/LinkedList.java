
public class LinkedList {

    public class Node {
        Double data;
        Node next;

        public Node(double data) {
            this.data = data;
            this.next = null;
        }

        public double getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    Node head;

    public void add(double data) {
        Node node = new Node(data);
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            // Traverses until the next value is null (End)
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public Node getHead() {
        return head;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public int count() {
        int count = 0;
        Node node = head;
        while (node != null) {
            count += 1;
            node = node.next;
        }
        return count;
    }

    public Double calculateAverage() {
        Double sum = 0.0;
        int total = 0;
        Node node = head;
        while (node != null) {
            total++;
            sum += node.data;
            node = node.next;
        }
        return sum / total;
    }

    public void addAtStart(double data) {
        Node node = new Node(data);
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void addAtIndex(int index, double data) {
        Node node = new Node(data);
        node.data = data;
        node.next = null;

        if (index == 0) {
            addAtStart(data);
        } else {
            Node n = head;

            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;

        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            System.out.println("\nItem Deleted : " + n1.data);
        }
    }
}
