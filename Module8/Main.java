package Module8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        // Prompt user to add five people
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter details for person " + i + ":");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Age: ");
            int age;
            try {
                age = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Setting age to 0.");
                age = 0;
            }
            Person person = new Person(firstName, lastName, age);
            queue.addPerson(person);
        }

        // Display unsorted queue
        System.out.println("\nUnsorted Queue:");
        displayQueue(queue);

        // Sort by last name (descending)
        queue.setSortByAge(false);
        queue.quickSort();
        System.out.println("\nQueue sorted by last name (descending):");
        displayQueue(queue);

        // Sort by age (descending)
        queue.setSortByAge(true);
        queue.quickSort();
        System.out.println("\nQueue sorted by age (descending):");
        displayQueue(queue);

        scanner.close();
    }

    // Helper method to display queue contents
    private static void displayQueue(Queue queue) {
        for (Person person : queue.getPeople()) {
            System.out.println(person);
        }
    }
}
