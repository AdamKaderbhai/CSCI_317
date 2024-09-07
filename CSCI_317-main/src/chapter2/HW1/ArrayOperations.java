import java.util.Arrays;
import java.util.Random;

class MyArray {
    protected int[] array;
    protected int size;
    protected int count;

    public MyArray(int size) {
        this.size = size;
        this.array = new int[size];
        this.count = 0;
    }

    public void add(int value) {
        if (count < size) {
            array[count++] = value;
        }
    }

    public void delete(int value) {
        for (int i = 0; i < count; i++) {
            if (array[i] == value) {
                array[i] = array[--count];
                return;
            }
        }
    }

    public boolean find(int value) {
        for (int i = 0; i < count; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}

class MyOrderedArray extends MyArray {

    public MyOrderedArray(int size) {
        super(size);
    }

    @Override
    public void add(int value) {
        if (count < size) {
            int i;
            for (i = count - 1; i >= 0 && array[i] > value; i--) {
                array[i + 1] = array[i];
            }
            array[i + 1] = value;
            count++;
        }
    }

    @Override
    public void delete(int value) {
        int i;
        for (i = 0; i < count; i++) {
            if (array[i] == value) {
                break;
            }
        }
        if (i < count) {
            for (int j = i; j < count - 1; j++) {
                array[j] = array[j + 1];
            }
            count--;
        }
    }

    @Override
    public boolean find(int value) {
        return Arrays.binarySearch(array, 0, count, value) >= 0;
    }
}

public class ArrayOperations {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random rand = new Random();

        for (int size : sizes) {
            MyArray array = new MyArray(size);
            MyOrderedArray orderedArray = new MyOrderedArray(size);

            // Populate arrays
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(size);
                array.add(value);
                orderedArray.add(value);
            }

            // Time delete operation
            int deleteValue = rand.nextInt(size);
            long startTime = System.currentTimeMillis();
            array.delete(deleteValue);
            long endTime = System.currentTimeMillis();
            System.out.println("MyArray delete time for size " + size + ": " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            orderedArray.delete(deleteValue);
            endTime = System.currentTimeMillis();
            System.out.println("MyOrderedArray delete time for size " + size + ": " + (endTime - startTime) + " ms");

            // Time find operation
            int findValue = size;
            startTime = System.currentTimeMillis();
            array.find(findValue);
            endTime = System.currentTimeMillis();
            System.out.println("MyArray find time for size " + size + ": " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            orderedArray.find(findValue);
            endTime = System.currentTimeMillis();
            System.out.println("MyOrderedArray find time for size " + size + ": " + (endTime - startTime) + " ms");

            // Time insert operation
            int insertValue = rand.nextInt(size);
            startTime = System.currentTimeMillis();
            array.add(insertValue);
            endTime = System.currentTimeMillis();
            System.out.println("MyArray insert time for size " + size + ": " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            orderedArray.add(insertValue);
            endTime = System.currentTimeMillis();
            System.out.println("MyOrderedArray insert time for size " + size + ": " + (endTime - startTime) + " ms");
        }
    }
}