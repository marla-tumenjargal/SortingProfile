/**
 * Implementation for QuickSort, implements the sort[] method from SortingAlgorithm
 */
public class QuickSort implements SortingAlgorithm {
    /**
     * Implementation for sort[] using Quick sort, makes a 'recursive' call to the quickSort[] method
     * @param array, the given array to be sorted
     */
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * quickSort[] method that implements recursively and sorts the elements of the array between 'low' and 'high'
     * @param array, the given array to be sorted
     * @param low, low
     * @param high, high
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * partitions the array based on a pivot element (re-arranges the elements so that all the smaller elements are placed before
     * pivot, and larger ones are after)
     *
     * pivot is the last element of the subarrat
     * @param array, array to be sorted
     * @param low, low
     * @param high, high
     * @return int
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
