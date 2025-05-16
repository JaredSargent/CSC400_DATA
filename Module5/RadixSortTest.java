package Module5;

public class RadixSortTest {
    public static void main(String[] args) {
        // Initialize the array as specified
        Integer[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        
        // Print the original array
        System.out.println("Original array:");
        printArray(arr);
        
        // Perform radix sort and print after each digit
        System.out.println("\nSorting steps:");
        radixSortWithSteps(arr);
        
        // Print the sorted array
        System.out.println("\nSorted array:");
        printArray(arr);
    }

    // Helper method to print the array
    private static void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Modified radix sort to print steps after each digit
    private static void radixSortWithSteps(Integer[] arr) {
        int max = getMax(arr);
        int step = 1;

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
            System.out.println("After sorting by digit " + (step++) + " (exp=" + exp + "):");
            printArray(arr);
        }
    }

    // Copied from RadixSort to avoid modifying the original class
    private static int getMax(Integer[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void countingSort(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}