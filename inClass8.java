public class inClass8 {






    public static void toString(int [] arr) {
        String printArray = "";
        for (int i = 0; i <arr.length-1 ; i++) {
            printArray += arr[i] + " , ";
        }

        System.out.println(printArray);
    }

    public static void mergesort(){

    }

    public static void merge(){

    }

    public static void quicksortMiddle(){

    }

    public static int particion2(int [] array, int begin, int end){


        int pivot = array[(begin + end)/2];
        end = array.length-1;

        int i = (begin - 1);


        int j = end;

        

        int temp = array[pivot];
        array[pivot] = array[j];
        array[j] = temp;



        for ( j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        return i+1;
    }
  






    public static void main(String[] args) {
        int [] arr = new int[]{8, 1, 4, 1, 5, 9, 2, 6, 5};

        toString(arr);
        System.out.println(particion2(arr,0,arr.length-1));

    }
}
