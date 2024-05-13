
public class ConsoleInterface {

    public void initalizeList() {
        // Create Student objects
        Student st1 = new Student(1, "James", "ICT");
        Student st2 = new Student(2, "Daniel", "Accounting");
        Student st3 = new Student(3, "Lucky", "Physics");
        Student st4 = new Student(4, "Samantha", "Law");

        // Add to the Linked List
        LinkedList<Student> students = new LinkedList<>();
        students.append(st1);
        students.append(st2);
        students.append(st3);
        students.append(st4);

        students.print();
    }

}
