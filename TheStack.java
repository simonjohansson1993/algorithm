import java.util.Arrays;

public class TheStack {
    private String[] stackArray;

    private int stackSize;

    private int topOfStack = -1; //shows its empy

    TheStack(int size) {
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void displaytheStack() {
        for (int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();

        for (int n = 0; n < stackSize; n++) {
            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");
        for (int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();

        for (int n = 0; n < stackSize; n++) {
            if (stackArray[n].equals("-1"))
                System.out.print("|      ");

            else System.out.print(String.format("| %2s " + " ", stackArray[n]));
        }
        System.out.println("|");
        for (int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();
    }

    public void push(String input) { //push informations in

        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
        } else System.out.println("Sorry but the stack is full");
        displaytheStack();
        System.out.println("PUSH " + input + " was added to the stack");
    }

    public String pop() {        //remove lates element
        if (topOfStack >= 0) {
            displaytheStack();

            System.out.println("Pop " + stackArray[topOfStack] + " was removed from stack");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        } else {
            displaytheStack();
            System.out.println("Sorry but the stack is empty");
            return "-1";
        }
    }

    public String peek() {       //Look at last element only
        displaytheStack();
        System.out.println("Peek " + stackArray[topOfStack] + " Is at the top of stack");

        return stackArray[topOfStack];
    }


    public void pushMany(String multipleValues) {

        String[] tempString = multipleValues.split(" ");

        for (int i = 0; i < tempString.length; i++) {

            push(tempString[i]);

        }
    }
    
    public void popAll(){

        for (int i = topOfStack; i >=0 ; i--) {
            pop();
        }
    }




    public static void main(String[] args) {

        TheStack theStack = new TheStack(10);
        
        theStack.push("10");
        
        theStack.push("15");
        
        theStack.peek();
        
        theStack.pop();
        
        theStack.pushMany("12 13 14 15");

        theStack.popAll();

        theStack.displaytheStack();

    }
}
