public class QuickSort_MOT {
    //Quick-sort with median-of-three pivot selection
    public long counter = 0;

    // find partition position
    public int partition(int array[], int first, int last) {

        // select the median of three element as a pivot
        int pivot = medianOfThree(array, first, last);

        // pointer for greater element
        int i = (first - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = first; j < last; j++) {
            counter++;
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swap the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[last];
        array[last] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    public int[] quickSort(int[] array, int first, int last) {
        counter++;
        if (first < last) {
            // p is pivot index after partitioning
            int p = partition(array, first, last);
            // recursively sort, left and right of pivot
            quickSort(array, first, p - 1);
            quickSort(array, p + 1, last);
        }
        return array;
    }

    public int medianOfThree(int[] array, int left, int right) {
        int temp;
        int middle = (int) Math.floor((left + right) / 2);
        if (array[middle] < array[left]) {
            temp = array[left];
            array[left] = array[middle];
            array[middle] = temp;
        }
        if (array[right] < array[left]) {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        if (array[middle] < array[right]) {
            temp = array[middle];
            array[middle] = array[right];
            array[right] = temp;
        }
        return array[right];
    }


}
