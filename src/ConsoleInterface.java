import java.util.Iterator;

public class ConsoleInterface {

    public void initalizeList() {
        // Create Student objects
        Student st1 = new Student(1, "James", new double[] { 90.0, 90.40, 90.40, 90.40 });
        Student st2 = new Student(2, "Daniel", new double[] { 66.4, 43.5, 34.3, 40.3 });
        Student st3 = new Student(3, "Lucky", new double[] { 39.0, 65.40, 44.40, 30.03 });
        Student st4 = new Student(4, "Samantha", new double[] { 39.0, 65.40, 44.40, 34.30 });

        // Add to the Linked List
        LinkedList<Student> students = new LinkedList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);

        printTable(students);
    }

    public void printTable(LinkedList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            printStudentDetails(iterator.next());
        }
    }

    private void printStudentDetails(Student student) {
        String line = "+-------------------------------+%n";
        // Printing out headings
        System.out.println("\n\n");
        System.out.printf(line);
        System.out.printf("| %-29s |%n", "YEAR PROGRESS");
        System.out.printf(line);
        System.out.printf("| %-12s | %-14s |%n", "STUDENT NAME", student.getName());
        System.out.printf("| %-12s | %-14s |%n", "STUDENT ID", student.getID());
        System.out.printf(line);
        System.out.printf("| %-12s | %-14s |%n", "TERMS", "MARKS");
        System.out.printf(line);

        double[] studentMarks = student.getMarks();
        double sum = 0.0;
        int termCount = 1;
        int itemCount = 0;
        for (Double num : studentMarks) {
            System.out.printf("| %-12s | %-14s |%n", "Term " + termCount, num + "%");
            sum += num;
            termCount++;
            itemCount++;
        }
        double avg = Math.round(((sum / itemCount) * 100)/ 100.0);
        // Calculating the student's average for the year
        System.out.printf(line);
        System.out.printf("| %-12s | %-14s |%n", "AVERAGE", avg + "%");
        System.out.printf(line);

    }
}
