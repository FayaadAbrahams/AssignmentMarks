import java.util.Scanner;

public class ConsoleInterface {

    public void fetchUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Marking Application!");
        System.out.println("=====================================");
        System.out.println("Please input a 1st Term Mark:");
        double mark1 = sc.nextDouble();
        System.out.println("Please input a 2nd Term Mark:");
        double mark2 = sc.nextDouble();
        System.out.println("Please input a 3rd Term Mark:");
        double mark3 = sc.nextDouble();
        System.out.println("Please input a 4th Term Mark:");
        double mark4 = sc.nextDouble();
        sc.close();
        addToLinkedList(mark1, mark2, mark3, mark4);
    }

    public void addToLinkedList(double mark1, double mark2, double mark3, double mark4) {
        // Add items to LinkedList
        LinkedList lk = new LinkedList();
        lk.add(mark1);
        lk.add(mark2);
        lk.add(mark3);
        lk.add(mark4);

        printTable(lk);
    }

    public void printTable(LinkedList datas) {
        int termCount = 1;
        // Printing out headings
        System.out.printf("--------------------------------------%n");
        System.out.printf("             YEAR PROGRESS      %n");
        System.out.printf("--------------------------------------%n");
        System.out.printf("| %-16s | %-5s |%n", "TERMS", "MARKS");
        System.out.printf("--------------------------------------%n");

        // Looping through all items in the LinkedList
        LinkedList.Node current = datas.getHead();
        while (current != null) {
            System.out.printf("| %-16s | %-5s |%n", "TERM " + termCount, current.getData());
            current = current.getNext();
            termCount++;
        }

        // Calculating the average for the year
        System.out.printf("--------------------------------------%n");
        System.out.printf("| %-16s | %-5s |%n", "AVERAGE", datas.calculateAverage());
    }

}
