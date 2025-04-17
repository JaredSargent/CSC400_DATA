package Module1;
/**
 * BagAssignment.java
 * This program implements a Bag data structure in Java and demonstrates its usage.
 * A Bag (multiset) allows duplicates and does not maintain order.
 * The Bag class supports adding, removing, checking existence, and counting elements.
 * The main method tests the Bag class with various operations.
 */

// Bag class to implement a multiset data structure
class Bag<T> {
    private T[] items; // Array to store elements
    private int size;  // Number of elements in the bag
    private static final int DEFAULT_CAPACITY = 10; // Initial capacity of the array

    // Constructor to initialize the bag
    @SuppressWarnings("unchecked")
    public Bag() {
        items = (T[]) new Object[DEFAULT_CAPACITY]; // Create array with initial capacity
        size = 0; // Initialize size to 0
    }

    // Method to add an item to the bag
    public void add(T item) {
        // If array is full, resize it
        if (size == items.length) {
            resize();
        }
        items[size] = item; // Add item at the end
        size++; // Increment size
    }

    // Method to remove one occurrence of an item from the bag
    public void remove(T item) {
        // Search for the item
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].equals(item)) {
                // Shift elements to fill the gap
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[size - 1] = null; // Clear last element
                size--; // Decrement size
                return; // Exit after removing one occurrence
            }
        }
    }

    // Method to check if an item exists in the bag
    public boolean contains(T item) {
        // Search for the item
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].equals(item)) {
                return true; // Item found
            }
        }
        return false; // Item not found
    }

    // Method to count occurrences of an item in the bag
    public int count(T item) {
        int count = 0;
        // Iterate through the bag and count matching items
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].equals(item)) {
                count++;
            }
        }
        return count;
    }

    // Helper method to resize the array when it’s full
    @SuppressWarnings("unchecked")
    private void resize() {
        // Double the size of the array
        T[] newItems = (T[]) new Object[items.length * 2];
        // Copy existing items to the new array
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems; // Update reference to new array
    }

    // Helper method to print the contents of the bag
    public void printContents() {
        System.out.print("Bag contents: ");
        if (size == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

// Main class to test the Bag implementation
public class BagAssignment {
    public static void main(String[] args) {
        // Create an instance of the Bag class
        Bag<String> bag = new Bag<>();

        // Add elements to the bag, including duplicates
        bag.add("apple");
        bag.add("apple");
        bag.add("banana");
        bag.add("orange");

        // Print the initial bag contents
        System.out.println("Initial bag contents:");
        bag.printContents();

        // Test the contains method
        System.out.println("Contains apple? " + bag.contains("apple"));
        System.out.println("Contains grape? " + bag.contains("grape"));

        // Test the count method
        System.out.println("Count of apple: " + bag.count("apple"));
        System.out.println("Count of banana: " + bag.count("banana"));

        // Remove an element from the bag
        System.out.println("Removing one apple...");
        bag.remove("apple");

        // Print the bag contents after removal
        System.out.println("Bag contents after removal:");
        bag.printContents();

        // Test contains method for the removed element
        System.out.println("Contains apple after removal? " + bag.contains("apple"));

        // Test count method for the removed element
        System.out.println("Count of apple after removal: " + bag.count("apple"));
    }
}