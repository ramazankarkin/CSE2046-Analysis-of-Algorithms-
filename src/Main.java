import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static long averageInsertion = 0;
    static long averageBinaryInsertion = 0;
    static long averageMerge = 0;
    static long averageQuick = 0;
    static long averageQuick_MOT = 0;
    static long averageHeap = 0;
    static long averageCounting = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("Please Chose varius input data:\n(1) For random input cases: \n(2) For sorted input cases: \n(3) For reversed input cases: \n(4) For special input cases:");
        Main is = new Main();
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        if (a == 1) {
            System.out.println("**************** Random Cases ****************");
            String[] file = new String[]{"random-100", "random-1000", "random-2000", "random-3000", "random-4000", "random-5000",};
            for (String filename : file) {
                int[] arr = is.file_handle(filename);
                is.sort(arr);
            }

        } else if (a == 2) {
            System.out.println("**************** Sorted Cases ****************");
            String[] file = new String[]{"sorted-100", "sorted-1000", "sorted-2000", "sorted-3000", "sorted-4000", "sorted-5000"};
            for (String filename : file) {
                int[] arr = is.file_handle(filename);
                is.sort(arr);
            }
        } else if (a == 3) {
            System.out.println("**************** Reversed Cases ****************");
            String[] file = new String[]{"reversed-100", "reversed-1000", "reversed-2000", "reversed-3000", "reversed-4000", "reversed-5000"};
            for (String filename : file) {
                int[] arr = is.file_handle(filename);
                is.sort(arr);
            }
        } else if (a == 4) {
            System.out.println("**************** Special Cases ****************");
            String[] file = new String[]{"all_9999_5000", "all_one_5000", "all_zero_nine_5000", "one_zero_5000"};
            for (String filename : file) {
                int[] arr = is.file_handle(filename);
                is.sort(arr);
            }
        } else {
            System.out.println("Please enter correct value:");

        }


    }

    public int[] file_handle(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ramazan\\Google Drive\\cse_246\\src\\test_txt\\" + fileName + ".txt"));
        List<Integer> numbers = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] strNumbers = line.split(" ");
            for (String strNumber : strNumbers) {
                numbers.add(Integer.parseInt(strNumber));
            }

        }
        br.close();


        int[] arr = new int[numbers.size()];
        int n = arr.length;
        // ArrayList to Array Conversion
        System.out.println("\nSorting Algorithm Comparisons:\n ");
        System.out.println(fileName + " input is:");
        for (int i = 0; i < numbers.size(); i++) {
            arr[i] = numbers.get(i);
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");

        return arr;


    }


    public void sort(int[] arr) {
        InsertionSort insertionsort = new InsertionSort();
        BinaryInsertionSort binaryinsertion = new BinaryInsertionSort();
        MergeSort mergesort = new MergeSort();
        QuickSort quicksort = new QuickSort();
        QuickSort_MOT quicksortMOT = new QuickSort_MOT();
        HeapSort heapsort = new HeapSort();
        CountingSort counting = new CountingSort();
        System.out.println(" ");

        int n = arr.length;

        System.out.print("Insertion sort: ");
        int[] arr1 = arr.clone();
        for (int iter : insertionsort.insertionSort(arr1))
            System.out.print(iter + " ");
        System.out.println(" ");

        int[] arr2 = arr.clone();
        System.out.print("Binaryinsertion sort: ");
        for (int iter : binaryinsertion.binaryInsertionSort(arr2))
            System.out.print(iter + " ");
        System.out.println(" ");

        int[] arr3 = arr.clone();
        int n3 = arr3.length;
        System.out.print("Merge sort: ");
        for (int iter1 : mergesort.sort(arr3, 0, n3 - 1))
            System.out.print(iter1 + " ");
        System.out.println(" ");

        int[] arr4 = arr.clone();
        int n4 = arr4.length;
        System.out.print("Quick sort: ");
        for (int iter2 : quicksort.quickSort(arr4, 0, n4 - 1))
            System.out.print(iter2 + " ");
        System.out.println(" ");

        int[] arr5 = arr.clone();
        int n5 = arr5.length;
        System.out.print("Quick sort MOT: ");
        for (int iter3 : quicksortMOT.quickSort(arr5, 0, n5 - 1))
            System.out.print(iter3 + " ");
        System.out.println(" ");

        int[] arr6 = arr.clone();
        System.out.print("Heap sort: ");
        for (int iter4 : heapsort.sort(arr6))
            System.out.print(iter4 + " ");
        System.out.println(" ");

        int[] arr7 = arr.clone();
        System.out.print("Counting sort: ");
        for (int iter5 : counting.countSort(arr7))
            System.out.print(iter5 + " ");


        System.out.println("\n");
        System.out.println("Insertion sort counter: " + insertionsort.counter);
        System.out.println("Binaryinsertion sort counter: " + binaryinsertion.counter);
        System.out.println("Merge sort counter: " + mergesort.counter);
        System.out.println("Quick sort counter: " + quicksort.counter);
        System.out.println("Quick sort Median of three counter: " + quicksortMOT.counter);
        System.out.println("Heap sort counter:  " + heapsort.counter);
        System.out.println("Counting sort counter:  " + counting.counter);
        System.out.println("");


        long startTime = System.nanoTime();
        insertionsort.insertionSort(arr);
        long endTime = System.nanoTime();

        long startTime1 = System.nanoTime();
        binaryinsertion.binaryInsertionSort(arr);
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        mergesort.sort(arr, 0, n - 1);
        long endTime2 = System.nanoTime();

        long startTime3 = System.nanoTime();
        quicksort.quickSort(arr, 0, n - 1);
        long endTime3 = System.nanoTime();

        long startTime4 = System.nanoTime();
        quicksortMOT.quickSort(arr, 0, n - 1);
        long endTime4 = System.nanoTime();

        long startTime5 = System.nanoTime();
        heapsort.sort(arr);
        long endTime5 = System.nanoTime();

        long startTime6 = System.nanoTime();
        counting.countSort(arr);
        long endTime6 = System.nanoTime();


        System.out.println("Insertion sort took " + (endTime - startTime) + " nanoseconds");
        System.out.println("Binaryinsertion sort took " + (endTime1 - startTime1) + " nanoseconds");
        System.out.println("Merge sort took " + (endTime2 - startTime2) + " nanoseconds");
        System.out.println("Quick sort took " + (endTime3 - startTime3) + " nanoseconds");
        System.out.println("Quick sort Median of three took: " + (endTime4 - startTime4) + " nanoseconds");
        System.out.println("Heap sort took " + (endTime5 - startTime5) + " nanoseconds");
        System.out.println("Counting sort took " + (endTime6 - startTime6) + " nanoseconds");


    }


}
