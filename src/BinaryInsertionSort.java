public class BinaryInsertionSort {
    public long counter = 0;
    public long counter1 = 0;

    public int[] binaryInsertionSort(int[] array) {
        int n = array.length;
        // traversing from 1 to size of array.
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int insertedPosition = binarySearch(array, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; j--) {
                array[j + 1] = array[j];
            }

            array[insertedPosition] = key;
        }
        return array;
    }

    public int binarySearch(int[] array, int left, int right, int key) {
        while (counter++ >= 0 && left <= right) {
            // find middle element
            int mid = (int) Math.ceil((left + right) / 2);
            if (key < array[mid]) {
                // if key smaller than middle, then it is in left sublist
                right = mid - 1;
            } else {
                // else the key is in right sublist
                left = mid + 1;
            }
        }

        return left;
    }


}
