public class ConsoleInterface {

    public void initalizeList() {
        // Create Student objects
        Student st1 = new Student(1, "James", new double[] { 90.0, 90.40, 90.40, 90.40 });
        Student st2 = new Student(2, "Daniel", new double[] { 66.4, 43.5, 34.3 });
        Student st3 = new Student(3, "Lucky", new double[] { 39.0, 65.40, 44.40 });
        Student st4 = new Student(4, "Samantha", new double[] { 39.0, 65.40, 44.40 });

        // Add to the Linked List
        LinkedList lk = new LinkedList();
        lk.add(st1);
        lk.add(st2);
        lk.add(st3);
        lk.add(st4);

        printTable(lk);
    }

    public void printTable(LinkedList datas) {
        // Looping through all items in the LinkedList
        LinkedList.Node current = datas.head;

        while (current != null) {
            // Printing out headings
            System.out.println("");
            System.out.printf("STUDENT NAME => %s     %n", current.student.getName());
            System.out.printf("STUDENT ID NO. => %s     %n", current.student.getID());
            System.out.printf("--------------------------------------%n");
            System.out.printf("             YEAR PROGRESS      %n");
            System.out.printf("--------------------------------------%n");
            System.out.printf("| %-10s | %-5s |%n", "TERMS", "MARKS");
            System.out.printf("--------------------------------------%n");

            double[] studentMarks = current.student.getMarks();
            double sum = 0.0;
            int termCount = 1;
            for (Double num : studentMarks) {
                System.out.printf("| %-10s | %-5s |%n", "T" + termCount, num + "%");
                sum += num;
                termCount++;
            }
            double avg = sum / termCount;
            // Calculating the student's average for the year
            System.out.printf("--------------------------------------%n");
            System.out.printf("| %-10s | %-5s |%n", "STUDENT AVERAGE =>", avg + "%");
            System.out.printf("--------------------------------------%n");
            current = current.next;
        }
    }

}
