public class InsertionSort {
    public long counter = 0;

    public int[] insertionSort(int[] array) {
        int n = array.length;
        // traversing from 1 to size of array.
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i;
            //carry list of elements to the right which larger than trying to insert
            while (counter++ >= 0 && j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;

            }
            array[j] = key;
        }
        return array;
    }
}