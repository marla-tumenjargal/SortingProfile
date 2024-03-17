/**
 * Implementation for InsertionSort, implements the sort[] method from SortingAlgorithm
 */
public class InsertionSort implements SortingAlgorithm {
    /**
     * implemented sort[] method using insertion sort
     * @param array, a given array to be sorted
     */
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {

            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
