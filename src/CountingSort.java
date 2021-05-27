public class CountingSort {
    public long counter = 0;


    public int[] countSort(int[] array) {

        int n = array.length;
        int[] output = new int[n + 1];


        int max = array[0];
        // First, find the largest element in array
        for (int i = 1; i < n; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
            counter++;
        }

        // Store the value of each element
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
            counter++;
        }

        // Store the cumulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the array in count array, and place the elements in output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into the array
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
        return array;
    }
}
