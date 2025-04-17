// Bag Class
Class Bag<T>
    // Use an array to store elements
    Declare array items of type T with initial size 10
    Declare integer size to track number of elements

    // Constructor
    Method Bag()
        Initialize items array with size 10
        Set size to 0
    End Method

    // Add an item to the bag
    Method add(T item)
        If size equals items.length
            Double the size of items array
        End If
        Set items[size] to item
        Increment size
    End Method

    // Remove one occurrence of an item
    Method remove(T item)
        For i from 0 to size-1
            If items[i] equals item
                Shift elements after i one position left
                Decrement size
                Return
            End If
        End For
    End Method

    // Check if an item exists in the bag
    Method contains(T item) returns boolean
        For i from 0 to size-1
            If items[i] equals item
                Return true
            End If
        End For
        Return false
    End Method

    // Count occurrences of an item
    Method count(T item) returns integer
        Set count to 0
        For i from 0 to size-1
            If items[i] equals item
                Increment count
            End If
        End For
        Return count
    End Method

    // Helper method to print bag contents
    Method printContents()
        For i from 0 to size-1
            Print items[i]
        End For
    End Method
End Class

// Main Program to Test Bag
Program Main
    Create new Bag<String> called bag
    Add "apple" to bag
    Add "apple" to bag
    Add "banana" to bag
    Add "orange" to bag
    Print "Initial bag contents:"
    Call bag.printContents()
    Print "Contains apple? " + bag.contains("apple")
    Print "Contains grape? " + bag.contains("grape")
    Print "Count of apple: " + bag.count("apple")
    Print "Count of banana: " + bag.count("banana")
    Print "Removing one apple..."
    Call bag.remove("apple")
    Print "Bag contents after removal:"
    Call bag.printContents()
    Print "Contains apple after removal? " + bag.contains("apple")
    Print "Count of apple after removal: " + bag.count("apple")
End Program