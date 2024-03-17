import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Main app that interacts and outputs with the terminal, I/O point
 */
public class SortingApp {

    /**
     * main method of sorting app
     * @param args, args
     */
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 20000, 30000, 40000};
        String[] types = {"Random", "Sorted", "Reverse-sorted"};

        for (int size : sizes) {
            for (String type : types) {
                int[] array;

                if (type.equals("Random")) {
                    array = new Random().ints(size).toArray();
                } else if (type.equals("Sorted")) {
                    array = IntStream.range(0, size).toArray();
                } else if (type.equals("Reverse-sorted")) {
                    array = IntStream.iterate(size, i -> i - 1).limit(size).toArray();
                } else {
                    throw new IllegalArgumentException("that is not a type of array");
                }

                long selectionSortTime = 0;
                long insertionSortTime = 0;
                long mergeSortTime = 0;
                long quickSortTime = 0;

                for (int i = 0; i < 1000; i++) {
                    int[] arrayCopy = Arrays.copyOf(array, array.length);

                    Stopwatch stopwatch = new Stopwatch();
                    stopwatch.start();
                    new SelectionSort().sort(arrayCopy);
                    stopwatch.stop();
                    selectionSortTime += stopwatch.elapsedTime();

                    arrayCopy = Arrays.copyOf(array, array.length);

                    stopwatch.reset();
                    stopwatch.start();
                    new InsertionSort().sort(arrayCopy);
                    stopwatch.stop();
                    insertionSortTime += stopwatch.elapsedTime();

                    arrayCopy = Arrays.copyOf(array, array.length);

                    stopwatch.reset();
                    stopwatch.start();
                    new MergeSort().sort(arrayCopy);
                    stopwatch.stop();
                    mergeSortTime += stopwatch.elapsedTime();

                    arrayCopy = Arrays.copyOf(array, array.length);

                    stopwatch.reset();
                    stopwatch.start();
                    new QuickSort().sort(arrayCopy);
                    stopwatch.stop();
                    quickSortTime += stopwatch.elapsedTime();
                }

                double averageSelectionSortTime = selectionSortTime / (double) 1000;
                double averageInsertionSortTime = insertionSortTime / (double) 1000;
                double averageMergeSortTime = mergeSortTime / (double) 1000;
                double averageQuickSortTime = quickSortTime / (double) 1000;
                System.out.printf("Array Size: %d, Array Type: %s%n" +
                                "Selection Sort Average Time: %.2f%n" +
                                "Insertion Sort Average Time: %.2f%n" +
                                "Merge Sort Average Time: %.2f%n" +
                                "Quick Sort Average Time: %.2f%n", size, type, averageSelectionSortTime, averageInsertionSortTime, averageMergeSortTime, averageQuickSortTime);

            }
        }
    }
}


/**
 *
 *
 * Array Size     Array Type     Selection Sort Insertion Sort Merge Sort
 * 100            Random         11007.55       6785.01        4033.91        1966.18
 * 100            Sorted         1704.89        815.94         2273.50        2568.82
 * 100            Reverse-sorted 2501.90        941.98         2672.54        2326.59
 * 1000           Random         163939.82      48604.44       28566.69       9988.44
 * 1000           Sorted         148211.78      692.68         22578.29       200982.88
 * 1000           Reverse-sorted 205168.39      88190.80       25468.66       174533.50
 * 10000          Random         15164910.88    4423911.43     563595.83      376665.27
 *
 *
 *
 *
 *
 */