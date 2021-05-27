public class MergeSort {
    public long counter = 0;
    public long counter1 = 0;

    public void merge(int array[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int left[] = new int[n1];
        int right[] = new int[n2];

        //Copy elements to temp arrays
        for (int i = 0; i < n1; ++i)
            left[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = array[m + 1 + j];


        // Initial indexes for sub-array
        int i = 0;
        int j = 0;

        // Initial index for merged sub-array
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // remaining elements of L[] copy
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        //remaining elements of R[] copy
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }


    // sort function which sorts array[from l to r] using function merge()
    public int[] sort(int array[], int left, int right) {
        counter++;
        if (left < right) {
            // Find the middle point
            int m = left + (right - left) / 2;

            // Sort first and second halves
            sort(array, left, m);
            sort(array, m + 1, right);

            // Merge the sorted halves
            merge(array, left, m, right);
        }
        return array;
    }


}
