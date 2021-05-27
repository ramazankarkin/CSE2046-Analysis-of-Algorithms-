
public class QuickSort {
    public long counter = 0;

    public int partition(int array[], int first, int last) {
        // indexing first  element
        int i = first + 1;
        int temp;
        // setting pivot as first element
        int pivot = array[first];            //make the first element as pivot element.
        for (int j = first + 1; j <= last; j++) {
    /*rearrange the array by putting elements which are less than pivot
       on one side and which are greater that on other. */
            counter++;
            if (array[j] < pivot) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                // increment i element until finds an element greater than pivot
                i += 1;
            }
        }
        //put the pivot element in its proper place.
        temp = array[first];
        array[first] = array[i - 1];
        array[i - 1] = temp;
        return i - 1;                      //return the position of the pivot
    }


    public int[] quickSort(int[] array, int first, int last) {


        // p is pivot index after partitioning
        if (first < last) {

            int p = partition(array, first, last);
            // recursively sort, left and right of pivot
            quickSort(array, first, p - 1);
            quickSort(array, p + 1, last);
        }
        return array;
    }


}
