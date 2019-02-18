import java.util.Arrays;
import java.math.*;

public class LabSorting {

  static long startTime;
  static long endTime;


  private static void swap(int[] array, int i, int j) {
   int temp;
    temp = array[i];
    array[i]=array[j];
    array[j]=temp;
  }

  /**
   * Hands on session 2 Exercise 1 Bubble sort
   *
   * @param array the array to sort
   */
  public static void bubbleSort(int[] array) {
    int temp;
    int arraySize = array.length-1;
    if(array.length<2){
      throw new UnsupportedOperationException("array must have more than 1 element to be sorted");

    } else

    for (int i = 0; i <arraySize ; i++) {
      for (int j = 0; j < arraySize-i ; j++) {
        if (array[j] > array [j+1]){
          temp = array[j];
          array[j]=array[j+1];
          array[j+1]=temp;
        }
      }
    }
  }

  public static void bubbleSortEfficient (int [] array) {
    int temp;
    int arraySize= array.length-1;
  boolean swapped = true;


    for (int i = 0; swapped && i < arraySize; i++) {
        swapped = false;
      for (int j = 0; j <arraySize-i ; j++) {
        if(array[j] > array[j+1]){
          temp = array[j];
          array[j] = array [j+1];
          array[j+1] = temp;
                  swapped = true;
        }
      }
    }
    endTime= System.currentTimeMillis();
    System.out.println("BubbleSort On Crack took: + " + (endTime-startTime));
  }


  /**
   * Hands on session 2 Exercise 2 Insertion sort
   *
   * @param array The array to sort
   */
  public static void insertionSort(int[] array) {

    int temp = 0;


    if(array.length<2){
      throw new UnsupportedOperationException("Array need more than 2 element to be sorted");
    }
    else

      for (int i = 1; i <array.length ; i++) {
        temp = array[i];
        int j = i;
        for (; j > 0 && temp < array[j-1] ; j--) {
          array[j] = array[j-1];
        }

        array[j]= temp;
      }
  }



  /**
   * Hands on session 4 & Assignment 2 Question 5 Quicksort
   *
   * @param array the array to sort
   */
  public static void quickSort(int[] array) {
      quickSort(array, 0, array.length - 1, false);
  }

    public static void quickSortMedian(int[] array) {
        quickSort(array, 0, array.length - 1, true);
    }


    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end, final boolean useMedian) {

        // Base case.
        if (begin >= end) {
            return;
        }

        // Use median as pivot
        if (useMedian) {            // Put the pivot item at begin index
            int median = median(array,0,array.length-1,4);
            int temp = array[begin];
            array[begin] = array [4];
            array[4] = temp;



            // Partition the array.
            int pivotInd = partition(array, begin, end);

            // Now recursively quicksort the two partitions.

            quickSort(array, begin, pivotInd - 1, useMedian);
            quickSort(array, pivotInd + 1, end, useMedian);
        }
    }

    public static int median(int[] array, int begin, int end, int k) {
        int pivot = partition(array,begin,end);

        if (pivot > k){
            return median(array,begin,pivot-1,k);
        }
        else if (k > pivot){
            return median(array,pivot+1,end, k);
        }
        else{
            return array[k];
        }
    }





    private static int partition ( int[] array, int begin, int end){
        // Assumes that the pivot is located att array[begin]
        int pivot = array[begin];
        int temp;

        // Assumes that the pivot is located att array[begin]

        int i = begin-1; // index of smaller element
        end = array.length-1;


        for (int j = begin; j <= end; j++) {


          // If current element is smaller than or
          // equal to pivot
          if (array[j] <= pivot) {
            i++;                    //incrament i

            // swap arr[i] and arr[j]   swap
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;

          }
        }

        // swap arr[i+1] and pivot)     return pivot to position
        temp = array[i];
        array[i] = array[begin];
        array[begin] = temp;


        return i;
      }




  /**
       * Assignment 2 Question 5, Mergesort
       *
       * @param array the array to sort
       */
    public static void mergeSort ( int[] array){

        if (array.length <2){
            return;
        }

        int mid = (array.length)/2;

        int [] left = new int [mid] ;
        int [] right = new int [array.length-mid] ;

        for (int i = 0; i < mid; i++) {
            left [i] = array [i];
        }
        for (int i = 0; i < array.length-mid; i++) {
           right [i] = array [mid+i];
        }

        mergeSort(left);
        System.out.println(Arrays.toString(left));
        mergeSort(right);
        System.out.println(Arrays.toString(right));

        merge(array,left,right);
        // Recursevily mergesort

      // Merge the left and right sub-arrays

    }

    /**
     * Private help method that merge two sorted arrays into one
     *
     * @param array How far we have got in the result array
     * @param left  How far we have got in the left array
     * @param right How far we have got in the right array
     */
    private static void merge ( int[] array, int[] left, int[] right){
        int l = 0;
        int r = 0;
        int temp = 0;


        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                array[temp] = left[l];
                temp++;
                l++;
            } else {
                array[temp] = right[r];
                temp++;
                r++;
            }
        }


        while (l < left.length) {
            array[temp] = left[l];
            temp++;
            l++;
        }

        while (r < right.length) {
            array[temp] = right[r];
            temp++;
            r++;
        }



    }




    public static void main (String[]args){
      // Put code here to try out your algorithms
        int[] arr1 = new int[]{2, 3, 5, 2, 4, 3, 1};


        int[] arr2 = new int[]{5, 6, 9, 7, 3, 4, 8};
        int[] arr3 = new int[]{5, 6, 9, 7, 3, 4, 8};
        int[] arr4 = new int[]{5, 6, 9, 7, 3, 4, 8};
        int[] arr5 = new int[]{5, 6, 9, 7, 3, 4, 8};

        System.out.println("***************************************************");

        System.out.println("original array : " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Array sorted with bubble sort : " + Arrays.toString(arr1));
        System.out.println("***************************************************");

        System.out.println("original array : " + Arrays.toString(arr2));
        insertionSort(arr2);
        System.out.println("Array sorted with insertion sort : " + Arrays.toString(arr2));
        System.out.println("***************************************************");

        System.out.println("original array : " + Arrays.toString(arr3));
        quickSort(arr3);
        System.out.println("Array sorted with quick sort : " + Arrays.toString(arr3));
        System.out.println("***************************************************");

        System.out.println("original array : " + Arrays.toString(arr4));
        quickSortMedian(arr4);
        System.out.println("Array sorted with quick sort /w median: " + Arrays.toString(arr4));
        System.out.println("***************************************************");
        System.out.println("original array: " + Arrays.toString(arr5));
        System.out.println("Sorting before merge...");
        mergeSort(arr5);
        System.out.println("Array sorted with mergesort: " + Arrays.toString(arr5));
        System.out.println("***************************************************");







    }
  }
