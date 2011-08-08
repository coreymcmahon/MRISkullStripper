package coreymcmahon.mriskullstripper;



/**
 *
 * 
 * Adapted from http://www.vogella.de/articles/JavaAlgorithmsMergesort/article.html
 *
 * @author corey
 */
public class MergeSort {

    private int[] values;
    private int[] pointers;

    private int length;

    public static void main (String[] args) throws Exception {
        int[] values = {9,8,7,6,5,4,3,2,1};
        int[] pointers = {0,1,2,3,4,5,6,7,8};

        MergeSort ms = new MergeSort(values,pointers);
        ms.sort();

        for (int i=0 ; i<values.length ; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println("");
        for (int i=0 ; i<values.length ; i++) {
            System.out.print(pointers[i] + " ");
        }
    }

    public MergeSort (int[] _values, int[] _pointers) {
        values = _values;
        pointers = _pointers;
        length = values.length;
    }

    /**
     *
     */
    public void sort() { mergesort(0, length - 1); }

    /**
     *
     * @param low
     * @param high
     */
    private void mergesort(int low, int high) {
            // Check if low is smaller then high, if not then the array is sorted
            if (low < high) {
                    // Get the index of the element which is in the middle
                    int middle = (low + high) / 2;
                    // Sort the left side of the array
                    mergesort(low, middle);
                    // Sort the right side of the array
                    mergesort(middle + 1, high);
                    // Combine them both
                    merge(low, middle, high);
            }
    }

    private void merge(int low, int middle, int high) {

            // Helperarray
            int[] helper = new int[length];
            int[] helperPointers = new int[length];

            // Copy both parts into the helper array
            for (int i = low; i <= high; i++) {
                    helper[i] = values[i];
                    helperPointers[i] = pointers[i];
            }

            int i = low;
            int j = middle + 1;
            int k = low;
            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
                    if (helper[i] <= helper[j]) {
                            //numbers[k] = helper[i];
                            values[k] = helper[i];
                            pointers[k] = helperPointers[i];
                            i++;
                    } else {
                            //numbers[k] = helper[j];
                            values[k] = helper[j];
                            pointers[k] = helperPointers[j];
                            j++;
                    }
                    k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
                    //numbers[k] = helper[i];
                    values[k] = helper[i];
                    pointers[k] = helperPointers[i];
                    k++;
                    i++;
            }
            helper = null;

    }
}
