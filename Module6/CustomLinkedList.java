package Module6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomLinkedList {
    private Node head;

    // Node inner class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a new node with the given data at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
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

    // Delete the first occurrence of a node with the given data
    public boolean delete(int data) {
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Return an iterator for the linked list
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // LinkedListIterator inner class
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }

    // Read integers from a file and insert them into the list
    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int data = Integer.parseInt(line.trim());
                    insert(data);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid integer: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Test 1: Insert elements manually
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        System.out.println("After inserting 1, 2, 3:");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Test 2: Delete an element
        linkedList.delete(2);
        System.out.println("After deleting 2:");
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Test 3: Read from file
        linkedList = new CustomLinkedList(); // Reset the list
        linkedList.readFromFile("input.txt");
        System.out.println("After reading from file:");
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}