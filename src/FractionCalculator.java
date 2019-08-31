import java.util.Scanner;

public class FractionCalculator {
    public static Scanner input = new Scanner(System.in);
    public static String mathOperation;  // create a public variable to can be accessed in many methods
    public static void main(String args[]){
        intro();

        while (true) {
            mathOperation = getOperation(input); //getting operation
            Fraction num1 = getFraction(input); // getting first fraction
            Fraction num2 = getFraction(input);// getting second fraction
            Fraction result = new Fraction(); // to store final result

            if (mathOperation.equals("+")) {
                result = num1.add(num2);
            } else if (mathOperation.equals("-")) {
                result = num1.subtract(num2);
            } else if (mathOperation.equals("*")) {
                result = num1.multiply(num2);
            } else if (mathOperation.equals("/")) {
                result = num1.divide(num2);
            }

            if(mathOperation.equals("=")){
                System.out.println(num1+" = "+num2+" is "+num1.equals(num2));
            }
            else {
                result.toLowestTerms(); // making the simplest form of the fraction
                System.out.println(num1 + " " + mathOperation + " " + num2 + " = " + result+"\n------------------------------------------");
            }
        }
    }

    public static void intro(){
        System.out.println("\n***********This program is a fraction calculator**********" );
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit");
        System.out.println("Please enter your fractions in the form of a/b, where a and b are integers.");
        System.out.println("\n-------------------------------------------------------------------------------------------\n");
    }

    public static String getOperation(Scanner in){
        System.out.print("Please enter an operation (+, -, *, /, =, Q): ");
        String operation = in.next();

        // if the user wants to end the program
        if(operation.equalsIgnoreCase("q")){
            System.exit(0);
        }
        // be sure that the user entered a valid operation
        if(!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/") &&
                !operation.equals("="))
        {
            System.out.println("Invalid input! ");
            getOperation(input); // recursion
        }
        return operation;
    }

    public static Fraction getFraction(Scanner in){
        System.out.print("Please enter a fraction (a/b) or integer (a)");
        String fraction = in.next();
        // declare two variables to assign numerator and denominator
        int numerator,denominator;

        // if the user enters integer not a fraction
        if(!fraction.contains("/")){
            // try and catch blocks to avoid errors if the use enters an invalid fraction
            try{
                numerator = Integer.parseInt(fraction);
                return new Fraction(numerator);
            }
            catch (Exception e){
                System.out.print("Invalid fraction, ");
                getFraction(input);
            }

        }
        // if user enters a normal fraction
        else{
            // splitting user's input to convert it to integers and return the Fraction
            String [] fractionParts = fraction.split("/");

            // try and catch blocks to avoid errors if the use enters an invalid fraction
            try{
                numerator = Integer.parseInt(fractionParts[0]);
                denominator = Integer.parseInt(fractionParts[1]);
                return new Fraction(numerator,denominator);

            }
            catch (Exception e){
                System.out.print("Invalid fraction, ");
                getFraction(input);
            }

        }
        return new Fraction();

    }
}
