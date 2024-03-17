import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class PerformanceAnalysis {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 20000, 30000, 40000};
        String[] types = {"Random", "Sorted", "Reverse-sorted"};

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                "Array Size", "Array Type", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort");

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
                    throw new IllegalArgumentException("thats not an array");
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

                // Output results in grid format
                System.out.printf("%-15d%-15s%-15.2f%-15.2f%-15.2f%-15.2f%n",
                        size, type, averageSelectionSortTime, averageInsertionSortTime,
                        averageMergeSortTime, averageQuickSortTime);
            }
        }
    }
}
