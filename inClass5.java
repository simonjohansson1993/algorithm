public class inClass5 {


    private int [] theArray = new int [50];
    private int arraySize  = 10;


    public void generateRandomArray(){
        for (int i = 0; i < arraySize ; i++) {

            theArray[i]= (int) (Math.random()*10)+10;
        }
    }


    public void insertionSort(){

    for (int i = 1; i <theArray.length ; i++) {
        int temp = theArray[i];
        int j = i;


        for ( ; j>0 && temp < theArray[j-1] ; j--) {

            theArray[j] = theArray[j - 1];
        }
            theArray[j] = temp;
    }
}
/*

public void bubbleSort() {
    int temp;
    for (int i = 0; i <arraySize; i++) {


        for (int j = 0; j < arraySize -i ; j++) {

            if (theArray[j] > theArray [j+1]){
                temp = theArray[j];
                theArray[j]=theArray[j+1];
                theArray[j+1]=temp;
            }
        }
    }
}
*/
public void insertionSort2(){
    int temp = 0;

    for (int i = 1; i <arraySize ; i++) {
        temp = theArray[i];
        int j = i;

        for (; j > 0 && temp <theArray[j-1] ; j--) {
            theArray[j] = theArray[j-1];

        }
        theArray[j] = temp;
    }
}



public void swap (int firstIndex, int secondIndex){

        int temp = theArray[firstIndex];
        theArray[firstIndex] = theArray [secondIndex];
        theArray[secondIndex] = temp;
}

public void bubbleSort2(){      //more efficient bubblesort bestcase O(N)
    boolean swapped= true;

        for (int i = 0; swapped && i <arraySize ; i++) {
            swapped=false;

            for (int j = 0; j <arraySize-i-1 ; j++) {
          if(theArray[j] > theArray[j+1]){
              swap(j, j+1);
              swapped=true;
          }
        }
    }
}

    public String toString(){
        String printArray = "";
        for (int i = 0; i <arraySize ; i++) {
           printArray += theArray[i] + " , ";
        }

    return printArray;
    }

    public static void main(String[] args) {
            inClass5 theArray = new inClass5(); //create object
            theArray.generateRandomArray();  // create random array
            System.out.println(theArray);      // print unsorted array

        //theArray.bubbleSort2();              //Sort with bubble sort
        theArray.insertionSort2();
        System.out.println(theArray);       // Print sorted array

    }
}
