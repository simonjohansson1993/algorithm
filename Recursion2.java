

public class Recursion2 {
    public static long fibArray[]=new long[41];     //declare memorization array




    public static long factorial (int n) {

        int c, fact = 1;

        if (n < 0) {
            throw  new IllegalArgumentException("Number should not be non-negative");
        }
        else {
            for (c = 1; c <=n ; c++) {
                fact = fact * c;
            }
        }
        return fact;
    }
    public static long factorial_recursive (int n){

        if (n==1)
           return 1;

        else
           return factorial_recursive(n-1) + n;


    }

    public static void printDecimal(long n) {
        if (n>= 10){
            printDecimal(n/10);
            System.out.println((char) ('0' + (n%10)));
        }
    }

    public static int binarySearch(int [] a, int x){
        int low = 0;
        int high = a.length -1;
        int mid=0;

        while (low<= high) {
            mid = (high + low) / 2;

            if (a[mid] < x) {

                low = mid + 1;
            }

            else if (a[mid] > x) {

                high = mid - 1;
            }

            else{


                    low = high +1;
            }

        }
        return mid;

    }

    public static int binarySearch_recursive(int [] a, int x, int low, int high){
        int mid = (high + low)/2;

        if(high < low){
            return -1;
        }


        else if (a[mid] > x){
            return binarySearch_recursive(a,x,low, mid-1);
        }

        else if (a[mid] < x){
            return binarySearch_recursive(a, x,mid+1,high);
        }

        return mid;
    }

    public static long fib(int n) {

            if(n==0 ){
                return 0;
            }else if(n==1){
                return 1;
            } else {
                return fib(n - 1) + fib(n - 2);
            }
        }

        public static long fibWithMemorization (long n){
            long fibValue;
            if (n==0){
                return 0;
            }
            else if (n==1){
                return 1;
            }

            else if (fibArray[(int)n] != 0){
            return fibArray[(int)n];
            }

            else {

                fibValue = fibWithMemorization(n-1) + fibWithMemorization(n-2);
                fibArray [(int)n] = fibValue;

                return fibValue;
            }


        }

    public static int TobiasFib (int n){
        if (n==0) {
            return 0;
        }
        if (n==1){
            return 1;
        }
        else{

            int[] arr = new int[n+1];
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 1;

            for (int i = 3; i <=n ; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
            return arr[n];
        }


    }




    public static void main(String[] args) {

        System.out.println("The sum of 6! = " + factorial(6));
        System.out.println("The recursive sum of 6 = " + factorial_recursive(6));
        System.out.println("Decimals of 250: ");
        printDecimal(250);

        int [] a = {1,2,3,4,5,6};

        System.out.println("find value 5 at index " + binarySearch(a,5));

        System.out.println( "find value with recursive at index " + binarySearch_recursive(a,5,1,6));
        System.out.println();

        long preTime=System.currentTimeMillis();
        System.out.println("Value of 40th number in fibonacci series-> "+fib(40));
        long postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> "+(postTime-preTime) + " ms");

        fibArray[0]=1;
        fibArray[1]=1;
        preTime=System.currentTimeMillis();
        System.out.println("Value of 40th number in fibonacci series with memorization-> "+fibWithMemorization(40));
        postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> "+(postTime-preTime) + " ms");
        System.out.println();
        System.out.println("The complexity is O(N) because each number is now stored and therefor only computed once");
        System.out.println("\n");

        preTime=System.currentTimeMillis();
        System.out.println("Value of 40th number in fibonacci series with iteration-> "+TobiasFib(100));
        postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> "+(postTime-preTime) + " ms");

    }

}
