
public class Recursion {

    /**
     * Hands-on session 3 Exercise 1a returns the factorial of n, uses recursion
     *
     * @param n the number to calculate the factorial on
     * @return the factorial of n
     */
    public static int factorial(int n) {

        if (n == 1)
            return 1;

        else
            return factorial(n - 1) + n;

    }

    /**
     * Hands-on session 3 Exercise 1b reverts a string
     *
     * @param word the string to revert
     * @return the reverted string
     */
    public static String reverse(String word) {

        if (word.isEmpty()) {
            return word;
        }


        return reverse(word.substring(1)) + word.charAt(0);

    }

    /**
     * Hands-on session 3 Exercise 1c repeats the input string n times
     *
     * @param n    the amount of repetitions
     * @param word the string to repeat
     * @return a string containing word repeated n times
     */
    public static String repeat(int n, String word) {

        if (n == 1) {
            return word;
        }

        return repeat(n - 1, word) + word;
    }


    /**
     * Hands-on session 3 Exercise 1d checks if a string contains a character
     *
     * @param word   the string to check
     * @param letter the letter to find
     * @return true if character is found in string
     */
    public static Boolean contains(String word, char letter) {


        if (word.charAt(0) == letter) {             //baseCase
            return true;
        }



            return contains(word.substring(1), letter);

            }


    public static int maxCrossingSum(int[] array, int l, int m, int h) {

        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + array[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + array[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        return left_sum + right_sum;
    }

    // Returns sum of maxium sum subarray
    // in aa[l..h]
    static int maxSubArraySum(int arr[], int l,
                              int h) {
        // Base Case: Only one element
        if (l == h)
            return arr[l];

        // Find middle point
        int m = (l + h) / 2;

    /* Return maximum of following three
    possible cases:
    a) Maximum subarray sum in left half
    b) Maximum subarray sum in right half
    c) Maximum subarray sum such that the
    subarray crosses the midpoint */
        return Math.max(Math.max(maxSubArraySum(arr, l, m),
                maxSubArraySum(arr, m + 1, h)),
                maxCrossingSum(arr, l, m, h));
    }

    /**
     * Hands-on session 3 Exercise 3 The towers of Hanoi Watch the videos linked
     * in the description of this problem.
     *
     * @param n               amount of discs
     * @param sourcePole
     * @param destinationPole
     * @param auxiliaryPole
     */
    static void tower(int n, char sourcePole,
                      char destinationPole, char auxiliaryPole) {


        if (n == 1) {
            System.out.println("Move disk 1 from rod " + sourcePole + " to rod " + destinationPole);
            return;
        } else
            tower(n - 1, sourcePole, auxiliaryPole, destinationPole);
        System.out.println("Move disk " + n + " from rod " + sourcePole + " to rod " + destinationPole);
        tower(n - 1, auxiliaryPole, destinationPole, sourcePole);
    }

    //  Driver method


    public static void main(String[] args) {

        System.out.println(factorial(6));
        System.out.println(reverse("paris"));
        System.out.println(repeat(3, "Simon"));
        System.out.println(contains("Simon", 'n'));

        // int[] arr = {2, -8, 1, 7, 1, 8, 2};
        // int n = arr.length;

        //int max_sum = maxSubArraySum(arr, 0, n-1);

        //System.out.println("Maximum contiguous sum is "+
        //     max_sum);

        int n = 4; // Number of disks
        tower(n, 'A', 'C', 'B');  // A, B and C are names of rods

    }
}



