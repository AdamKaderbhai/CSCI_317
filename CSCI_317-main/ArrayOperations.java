
 // My name is Adam Kaderbhai I am a Sophomore pursuing computer science
 //I am taking this class because I want to explore different Data Structures and Algorithms that will be covered in this course using my previous knowledge of Java.
 //I enjoy cycling, reading and I usually like to create simple programs in Java and Python using my creativity.
 //I know Java and Python and looking forward to learning more languages in the future.
 // I wanna learn data structures and algorithms to improve my problem-solving skills and to be able to solve real-world problems using my programming skills. 
 

import java.util.Random;

public class ArrayOperations {
    public static void main(String[] args) {
        // Create three arrays with sizes 100, 1000, and 10000
        MyArray array100 = new MyArray(100);
        MyArray array1000 = new MyArray(1000);
        MyArray array10000 = new MyArray(10000);

        // Populate the arrays with random integers
        array100.populateWithRandomIntegers();
        array1000.populateWithRandomIntegers();
        array10000.populateWithRandomIntegers();

        // Time the deletion of an element from each array
        timeDeletion(array100, 50); // Deleting element at index 50
        timeDeletion(array1000, 500); // Deleting element at index 500
        timeDeletion(array10000, 5000); // Deleting element at index 5000

        // Time the search for an element that is not present in each array
        timeSearch(array100, 100); // Searching for element 100
        timeSearch(array1000, 1000); // Searching for element 1000
        timeSearch(array10000, 10000); // Searching for element 10000

        // Time the insertion of an element into each array
        timeInsertion(array100, 50, 999); // Inserting element 999 at index 50
        timeInsertion(array1000, 500, 9999); // Inserting element 9999 at index 500
        timeInsertion(array10000, 5000, 99999); // Inserting element 99999 at index 5000

        // Create three ordered arrays with sizes 100, 1000, and 10000
        MyArray orderedArray100 = new MyArray(100);
        MyArray orderedArray1000 = new MyArray(1000);
        MyArray orderedArray10000 = new MyArray(10000);

        // Populate the ordered arrays with random integers
        orderedArray100.populateWithRandomIntegers();
        orderedArray1000.populateWithRandomIntegers();
        orderedArray10000.populateWithRandomIntegers();

        // Time the deletion of an element from each ordered array
        timeDeletion(orderedArray100, 50); // Deleting element at index 50
        timeDeletion(orderedArray1000, 500); // Deleting element at index 500
        timeDeletion(orderedArray10000, 5000); // Deleting element at index 5000

        // Time the search for an element that is not present in each ordered array
        timeSearch(orderedArray100, 100); // Searching for element 100
        timeSearch(orderedArray1000, 1000); // Searching for element 1000
        timeSearch(orderedArray10000, 10000); // Searching for element 10000

        // Time the insertion of an element into each ordered array
        timeInsertion(orderedArray100, 50, 999); // Inserting element 999 at index 50
        timeInsertion(orderedArray1000, 500, 9999); // Inserting element 9999 at index 500
        timeInsertion(orderedArray10000, 5000, 99999); // Inserting element 99999 at index 5000
    }

    // Method to time the deletion of an element
    public static void timeDeletion(MyArray array, int index) {
        long startTimeNano = System.nanoTime();
        long startTimeMilli = System.currentTimeMillis();
        array.delete(index);
        long endTimeNano = System.nanoTime();
        long endTimeMilli = System.currentTimeMillis();
        long durationNano = endTimeNano - startTimeNano;
        long durationMilli = endTimeMilli - startTimeMilli;
        System.out.println("Time taken to delete element at index " + index + ": " + durationNano + " nanoseconds (" + durationMilli + " milliseconds)");
    }

    // Method to time the search for an element
    public static void timeSearch(MyArray array, int value) {
        long startTimeNano = System.nanoTime();
        long startTimeMilli = System.currentTimeMillis();
        boolean found = array.search(value);
        long endTimeNano = System.nanoTime();
        long endTimeMilli = System.currentTimeMillis();
        long durationNano = endTimeNano - startTimeNano;
        long durationMilli = endTimeMilli - startTimeMilli;
        System.out.println("Time taken to search for element " + value + ": " + durationNano + " nanoseconds (" + durationMilli + " milliseconds). Found: " + found);
    }

    // Method to time the insertion of an element
    public static void timeInsertion(MyArray array, int index, int value) {
        long startTimeNano = System.nanoTime();
        long startTimeMilli = System.currentTimeMillis();
        array.insert(index, value);
        long endTimeNano = System.nanoTime();
        long endTimeMilli = System.currentTimeMillis();
        long durationNano = endTimeNano - startTimeNano;
        long durationMilli = endTimeMilli - startTimeMilli;
        System.out.println("Time taken to insert element " + value + " at index " + index + ": " + durationNano + " nanoseconds (" + durationMilli + " milliseconds)");
    }
}

class MyArray {
    private int[] array;
    private int size;

    // Constructor to initialize the array with the given size
    public MyArray(int size) {
        this.size = size;
        array = new int[size];
    }

    // Method to add a value at a specific index
    public void add(int index, int value) {
        if (index >= 0 && index < size) {
            array[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Method to populate the array with random integers
    public void populateWithRandomIntegers() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            add(i, random.nextInt(size));
        }
    }

    // Method to delete an element at a specific index
    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0; // Optional: Reset the last element to 0
            size--;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Method to search for an element in the array
    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    // Method to insert an element at a specific index
    public void insert(int index, int value) {
        if (index >= 0 && index < size) {
            for (int i = size - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}

//Running Times:

/*
ORDERED ARRAY:

Time taken to delete element at index 50: 8200 nanoseconds (0 milliseconds)
Time taken to delete element at index 500: 15250 nanoseconds (0 milliseconds)
Time taken to delete element at index 5000: 142680 nanoseconds (0 milliseconds)
Time taken to search for element 100: 4410 nanoseconds (0 milliseconds). Found: false
Time taken to search for element 1000: 27870 nanoseconds (0 milliseconds). Found: false
Time taken to search for element 10000: 256960 nanoseconds (0 milliseconds). Found: false
Time taken to insert element 999 at index 50: 6440 nanoseconds (0 milliseconds)
Time taken to insert element 9999 at index 500: 17770 nanoseconds (0 milliseconds)
Time taken to insert element 99999 at index 5000: 167720 nanoseconds (0 milliseconds)


UNORDERED ARRAY:

Time taken to delete element at index 50: 2790 nanoseconds (0 milliseconds)
Time taken to delete element at index 500: 18340 nanoseconds (0 milliseconds)
Time taken to delete element at index 5000: 186790 nanoseconds (0 milliseconds)
Time taken to search for element 100: 3810 nanoseconds (0 milliseconds). Found: false
Time taken to search for element 1000: 30330 nanoseconds (0 milliseconds). Found: false
Time taken to search for element 10000: 280940 nanoseconds (1 milliseconds). Found: false
Time taken to insert element 999 at index 50: 2700 nanoseconds (0 milliseconds)
Time taken to insert element 9999 at index 500: 17230 nanoseconds (0 milliseconds)
Time taken to insert element 99999 at index 5000: 140770 nanoseconds (0 milliseconds)

 */