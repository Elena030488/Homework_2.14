package pro.sky.Homework_2.__algorithms_1.sort;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] array = new Integer[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 300) - 150);
        }
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);
        long start = System.currentTimeMillis();
        sortInsertion(array3);
        System.out.println("sort insertion: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        sortedSelection(array2);
        System.out.println("sort selection: " + (System.currentTimeMillis() - start));
        //start = System.currentTimeMillis();
        //bubbleSort(array);
        //System.out.println("bubble sort: " + (System.currentTimeMillis() - start));
    }

    public static void bubbleSort(Integer[] arr) {
        boolean sort = false;
        int temp;
        while (!sort) {
            sort = true;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sort = false;
                }
            }
        }
    }

    public static void sortedSelection(Integer[] arr) {
        int temp;
        for (int i = 1; i < arr.length - 1; i++) {
            int minElementIndex = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minElementIndex];
            arr[minElementIndex] = temp;
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
