
class Array3 {

    private final int max_elements = 200;
    private int size = 0;
    private int[] arr;

    public Array3(int n) {
        if ((n < 0) || (n > max_elements)) {
            throw new IllegalArgumentException("Array size must be non-negative");
        }
        arr = new int[max_elements];
        size = n;
    }

    /**
     * @return the size of the Array
     */
    public int size() {
        return size;
    }

    /**
     * Set the i-th element to x We are not checking whether the index is in bounds,
     * because dereferencing the array element does it for us.
     *
     * @param i the index of the element
     * @param x the element we're adding
     */
    public void set(int i, int x) {
        arr[i] = x;
    }

    /**
     * Get the i-th element, Again, we are not checking if the index is in bounds.
     *
     * @param i the index of the element to get
     * @return the element found
     */
    public int get(int i) {
        return arr[i];
    }

    /**
     * @return the content of the array as a String
     */
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        if (size > 0) {
            res.append(arr[0]);
            for (int i = 1; i < size; ++i) {
                res.append(", ");
                res.append(arr[i]);
            }
        }
        res.append("}");
        return res.toString();
    }

    /**
     * Hands on session 1 Exercise 1 - Insert element x at index i assuming i is max
     * the size of the array.
     *
     * @param i the index where to insert
     * @param x the element to insert
     */
    public void insert(int i, int x) {

        if (size == max_elements)
            throw new UnsupportedOperationException("Array exceeding max elements");

        if (i > size) {
            throw new UnsupportedOperationException("bigger than size");
        }

        for (int j = size; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = x;
        size++;

    }

    /**
     * Hands on session 1 Exercise 2
     *
     * @return true if the array is sorted
     */
    public boolean isSorted() {

        for (int i = 0; i < size-1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Hands on session 1 Exercise 3
     *
     * @return the length of longest increasing sub array
     */
    public int maxNonDecreasing() {

        int currentMax = 1;
        int max = 0;

        for (int j = 0; j < size; j++) {
            if (arr[j] <= arr[j + 1]) {
                currentMax++;

            } else {
                if (currentMax > max) {
                    max = currentMax;
                }
                currentMax = 1;
            }
        }
        return max;


    }

    /**
     * Hands on session 1 Exercise 4 - returns the index of the first number in the
     * first matching subarray
     *
     * @param b The subarray to compare with
     * @return the index where the subarray starts
     */
    public int subArrayIndex(Array3 b) {
        for (int i = 0; i <= (size - b.size()); i++) {

            boolean isEqual = true;
            int j = 0;

            while (isEqual && (j < b.size())) {
                if (arr[i + j] == b.get(j)) {
                    j++;
                } else {
                    isEqual = false;
                }
            }
            if (isEqual) {
                return i;
            }
        }

        return -1;
    }

    // Internal method for swapping
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Hands on Session 3 Exercise 2 Return the maximum sum of all contiguous
     * subarrays of the array.
     *
     * @param array the array
     * @param lo    the index of the low boundary of the subarray
     * @param hi    the index of the high boundary of the subarray
     * @return the sum of the subarray
     */
    public static int maxSubarraySum(int[] array, int lo, int hi) {
        throw new UnsupportedOperationException();
    }

    /**
     * Assignment 1 Question 1 Reverse the array
     */
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {

            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;

        }
    }

    /**
     * Assignment 1 Question 2 Remove the element of index i from the array.
     *
     * @param i the element to remove
     */
    public void remove(int i) {

        for (int j = i; j < size; j++) {
            arr[j] = arr[j + 1];
        }
        size--;

    }

    /**
     * Assignment 1 Question 2 Remove the element of index i from the array. This
     * method may change the order of the other elements of the array.
     *
     * @param i the element to remove
     */
    public void remove2(int i) {
        arr[i] = arr[size - 1];
        arr[size-1] = 0;
        size--;
    }

    /**
     * Assignment 1 Question 3 Return the index of the first occurrence of x in the
     * array, or -1 if x does not occur.
     *
     * @param x the element to find
     * @return the index of the first occurrence
     */
    public int find(int x) {
        for (int i = 0; i < size ; i++) {

            if (x == arr[i]){
                return i;
            }

        }
        return -1;
    }

    /**
     * Assignment 1 Question 4 Find the length of the longest palindrome that is a
     * contiguous subsequence of the array.
     *
     * @return The length of the palindrome
     */
    public int maxPalindrome() {

        int lengthOfPal = 1;
        int high;
        int low;

        if (size<1){
            return 0;
        }
        for (int i = 1; i < size; i++) {


            high = i;
            low = i - 1;

            while (low >= 0 && high < size && arr[low] == arr[high]) {

                if (high - low + 1 > lengthOfPal) {
                    lengthOfPal = high - low + 1;
                }
                high++;
                low--;
            }
            high = i + 1;
            low = i - 1;

            while (low >= 0 && high < size && arr[low] == arr[high]) {

                if (high - low + 1 > lengthOfPal) {
                    lengthOfPal = high - low + 1;
                }
                high++;
                low--;
            }

        }

        return lengthOfPal;
    }


    /**
     * Assignment 2 Question 3 returns the sum of the largest contiguous ascending
     * array
     *
     * @return the sum
     */
    public int maxInterval() {
        throw new UnsupportedOperationException();
    }

    /**
     * Assignment 2 Question 3 Return the median value of an array.
     *
     * @return the median
     */
    public int median() {
        throw new UnsupportedOperationException();
    }
    public static int multiply(int x){
        int sum = 0;
        int term = 1;

        for (int i = 1; i <= x ; i++) {

            term = term * x;
            sum += term;

        }
        return sum;
    }
    public static int multiply2(int x){

        int sum = x;
        int term = 0;

        for (int i = x; i > 1; i--) {
            if (x == i){
                term = x * x;
            }
            else{
                term = term * x;
            }
            sum += term;
        }
        return sum;
    }

    public static void main(String[] args) {
        Array3 a = new Array3(11);
        Array3 b = new Array3(3);
        a.set(0, 1);
        a.set(1, 5);
        a.set(2, 3);
        a.set(3, 4);
        a.set(4, 4);
        a.set(5, 3);
        a.set(6, 6);
        a.set(7, 7);
        a.set(8, 8);
        a.set(9, 9);
        a.set(10, 10);

        b.set(0, 3);
        b.set(1, 4);
        b.set(2, 4);

        System.out.println(a.toString());
        System.out.println(a.isSorted());
        System.out.println(a.subArrayIndex(b));
        System.out.println(a.maxPalindrome());
        a.reverse();
        System.out.println(a.toString());

        int x = 3;
        x = multiply(x);
        System.out.println(x);

        x = 3;
        x = multiply2(x);
        System.out.println(x);



    }
}
