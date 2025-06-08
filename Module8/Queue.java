package Module8;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Person> people;
    private boolean sortByAge; // Flag to determine sorting criteria

    // Constructor
    public Queue() {
        people = new ArrayList<>();
        sortByAge = false;
    }

    // Add a person to the queue
    public void addPerson(Person person) {
        people.add(person);
    }

    // Get the list of people
    public ArrayList<Person> getPeople() {
        return people;
    }

    // Set sorting criteria
    public void setSortByAge(boolean sortByAge) {
        this.sortByAge = sortByAge;
    }

    // Quicksort implementation
    public void quickSort() {
        quickSort(0, people.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Person pivot = people.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            boolean swap;
            if (sortByAge) {
                // Sort by age in descending order
                swap = people.get(j).getAge() > pivot.getAge();
            } else {
                // Sort by last name in descending order
                swap = people.get(j).getLastName().compareTo(pivot.getLastName()) > 0;
            }
            if (swap) {
                i++;
                // Swap elements
                Person temp = people.get(i);
                people.set(i, people.get(j));
                people.set(j, temp);
            }
        }
        // Place pivot in its final position
        Person temp = people.get(i + 1);
        people.set(i + 1, people.get(high));
        people.set(high, temp);
        return i + 1;
    }
}