/**
 * Implementation for MergeSort, implements the sort[] method from SortingAlgorithm
 */
public class MergeSort implements SortingAlgorithm {
    /**
     * implementation of the sort[] method for merge sort, recurisve call to the mergeSort[]
     * @param array, the given array to be sorted
     */
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * mergeSort[] 'business logic' where all the sorting happens
     * @param array, the given array to be sorted
     * @param left, left hand side of array
     * @param right, right hand side of array
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            int n1 = middle - left + 1;
            int n2 = right - middle;

            int[] tempLeft = new int[n1];
            int[] tempRight = new int[n2];

            for (int i = 0; i < n1; i++) {
                tempLeft[i] = array[left + i];
            }

            for (int i = 0; i < n2; i++) {
                tempRight[i] = array[middle + 1 + i];
            }

            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (tempLeft[i] <= tempRight[j]) {
                    array[k++] = tempLeft[i++];
                } else {
                    array[k++] = tempRight[j++];
                }
            }

            while (i < n1) {
                array[k++] = tempLeft[i++];
            }

            while (j < n2) {
                array[k++] = tempRight[j++];
            }
        }
    }
}
