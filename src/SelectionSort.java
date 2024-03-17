/**
 * Implementation of SelectionSort algorithm through the interface SortingAlgorithm's 'sort[]'
 */
public class SelectionSort implements SortingAlgorithm {
    /**
     * Implements selection sort by sorting an array in ascending order (determines lengths, iterates through n-2,
     * finds minimum element in unsorted part and swaps with the minimum element with index i
     *
     * it does this by finding an element smaller than the current mimumum such as at minIndex
     * @param array, the given array to be sorted
     */
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
