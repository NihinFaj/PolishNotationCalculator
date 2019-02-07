import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

/**
 * A Java program that evaluates Normal Polish Notation and prints out the result
 * This program reads from the standard input.
 *
 * @author Nihinlolamiwa Donaldson Fajemilehin
 * @version 21st of December, 2018
 */
public class polishParser
{

    /**
     * Constructor for objects of class polishParser
     */
    public polishParser()
    {
    }

    /**
     * The main method that evaluates the Normal Polish Notation 
     * and prints out the result.
     */
    public static void main(String[] args)
    {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        String input;
        String trimmedInput[];
        int output;

        input = scanner.nextLine();
        trimmedInput = input.split("\\s+");

        for(int i = trimmedInput.length - 1; i >= 0; i--) {
            if(isAnOperand(trimmedInput[i])) {
                // Value is an operand, hence, push into the stack
                stack.push(trimmedInput[i]);
            }
            else {
                // Value is an operator, hence, pop 2 operands from the stack 
                // and operate on them using the operator
                int valA = Integer.parseInt(String.valueOf(stack.peek()));
                stack.pop();
                int valB = Integer.parseInt(String.valueOf(stack.peek()));
                stack.pop();

                if(trimmedInput[i].equals("+")) {
                    output = valA + valB;
                    stack.push(output);
                }
                else if(trimmedInput[i].equals("-")) {
                    output = valA - valB;
                    stack.push(output);
                }
                else if(trimmedInput[i].equals("*")) {
                    output = valA * valB;
                    stack.push(output);
                }
            }
        }

        System.out.println("The result is " + stack.peek());
    }

    /**
     * Method to check if the value passed is an operand or not
     * @return True if it is an operand, and False if it is not
     */
    public static boolean isAnOperand(String newStr)
    {
        try {
            double newDouble = Double.parseDouble(newStr);
        }
        catch(NumberFormatException ex) {
            return false;
        }
        return true; 
    }
}
