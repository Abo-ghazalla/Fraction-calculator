import java.util.Scanner;

public class FractionCalculatorAdvanced {
    public static Scanner input = new Scanner(System.in);
    public static int numerator1,denominator1,numerator2,denominator2;
    public static String operation;

    public static void main(String args[]){
        intro();
        while (true) {
            prepareFractionsToBeCalculated(input);

            Fraction num1= new Fraction(numerator1,denominator1);
            Fraction num2 = new Fraction(numerator2,denominator2);
            Fraction result = new Fraction();


            if (operation.equals("+")) {
                result = num1.add(num2);
            }
            else if (operation.equals("-")) {
                result = num1.subtract(num2);
            }
            else if (operation.equals("*")) {
                result = num1.multiply(num2);
            }
            else if (operation.equals("/")) {
                result = num1.divide(num2);
            }

            if(operation.equals("=")){
                System.out.println(num1+" = "+num2+" is "+num1.equals(num2));
            }
            else {
                result.toLowestTerms();
                System.out.println(num1 + " " + operation + " " + num2 + " = " + result+"\n------------------------------------------");
            }
        }

    }

    public static void intro(){
        System.out.println("\n***********This program is a fraction calculator**********\n" +
                "It will add, subtract, multiply, and divide fractions until you type Q to quit\n" +
                "Valid Operations are of the from \"[FRAC] [OPERATION] [FRAC]\".\n" +
                "[FRAC] can be either a single integer or two integers separated by \"/\".\n" +
                "[OPERATION] can be +, -, *, / or =.\n" +
                "-------------------------------------------------------------------------------------------\n");
    }

    public static void prepareFractionsToBeCalculated(Scanner in) {

        while (true) {
            System.out.print("Enter an equation (Q to quit):");
            // get the equation from user
            String equation = in.nextLine();

            // if user want to exit the program
            if (equation.equalsIgnoreCase("q")) {
                System.exit(0);
            }

            // split the user's input int parts to check an make the operation
            String[] equParts = equation.split(" ");
            // be sure that user entered a three-part equation with a space between every two parts (fracOne operation fracTwo)
            if (equParts.length != 3) {
                System.out.println("Invalid! Equation must be \"[Frac] [OPERATION] [FRAC]\".");
                continue;
            }

            // assign the operation symbol to a public variable
            operation = equParts[1];

            // check if the mathematical symbol is valid (+ - / * =)
            if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/") &&
                    !operation.equals("=")) {
                System.out.println("Invalid! Equation must be \"[Frac] [OPERATION] [FRAC]\".");
                continue;
            }


            // if the first number is an integer not a fraction (with no "/")
            if (!equParts[0].contains("/")) {
                try {
                    numerator1 = Integer.parseInt(equParts[0]);
                    denominator1 = 1;
                }
                // if invalid integer
                catch (Exception e) {
                    System.out.println("Invalid! Equation must be \"[Frac] [OPERATION] [FRAC]\".");
                    continue;
                }
            }
            // if the first number is a fraction
            else {
                String[] fractionOneParts = equParts[0].split("/");

                // try and catch blocks to avoid errors if the use enters an invalid fraction
                try {
                    numerator1 = Integer.parseInt(fractionOneParts[0]);
                    denominator1 = Integer.parseInt(fractionOneParts[1]);
                }
                // if invalid fraction
                catch (Exception e) {
                    System.out.println("Invalid! Equation must be \"[Frac] [OPERATION] [FRAC]\".");
                    continue;
                }
            }
      //______________________________________________________________________________________

            // if the second number is an integer not a fraction (with no "/")
            if (!equParts[2].contains("/")) {

                // try and catch blocks to avoid errors if the use enters an invalid fraction
                try {
                    numerator2 = Integer.parseInt(equParts[2]);
                    denominator2 = 1;
                }
                // if invalid fraction
                catch (Exception e) {
                    System.out.println("Invalid! Equation must be \"[Frac] [OPERATION] [FRAC]\".");
                    continue;
                }
            }
            // if the second number is a fraction
            else {
                String[] fractionTwoParts = equParts[2].split("/");

                // try and catch blocks to avoid errors if the use enters an invalid fraction
                try {
                    numerator2 = Integer.parseInt(fractionTwoParts[0]);
                    denominator2 = Integer.parseInt(fractionTwoParts[1]);
                }
                // if invalid fraction
                catch (Exception e) {
                    System.out.println("Invalid! Equation must be \"[Frac] [OPERATION] [FRAC]\".");
                    continue;
                }
            }
            break;
        }
    }
}
