package module2;

import java.util.ArrayList;

class Bag<T> {
    private ArrayList<T> elements;

    // Constructor
    public Bag() {
        elements = new ArrayList<>();
    }

    // Add an element to the bag
    public void add(T item) {
        elements.add(item);
    }

    // Return total number of elements including duplicates
    public int size() {
        return elements.size();
    }

    // Merge another bag into this one
    public void merge(Bag<T> otherBag) {
        elements.addAll(otherBag.elements);
    }

    // Return a new bag with only distinct elements
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        for (T item : elements) {
            if (!distinctBag.elements.contains(item)) {
                distinctBag.add(item);
            }
        }
        return distinctBag;
    }

    // Helper method to print bag contents
    public void printBag() {
        System.out.println(elements);
    }
}

public class BagDemo {
    public static void main(String[] args) {
        // Create two bags
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // Add elements to bag1 (including duplicates)
        bag1.add("Apple");
        bag1.add("Banana");
        bag1.add("Apple");

        // Add elements to bag2 (including duplicates)
        bag2.add("Banana");
        bag2.add("Cherry");
        bag2.add("Date");

        // Print size of each bag
        System.out.println("Size of Bag 1: " + bag1.size());
        System.out.println("Size of Bag 2: " + bag2.size());

        // Merge bag2 into bag1
        bag1.merge(bag2);
        System.out.print("Merged Bag Contents: ");
        bag1.printBag();

        // Create a new bag with distinct elements
        Bag<String> distinctBag = bag1.distinct();
        System.out.print("Distinct Bag Contents: ");
        distinctBag.printBag();
    }
}
