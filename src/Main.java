/*
 * This program should take a quadratic equation
 * and solve it using the quadratic formula
 *
 * Quadratic Formula: x = (-b +-sqrt(b^2-4ac))/2*a
 *
 *
 * todo:
 *  is there a way to check for the parent function without
 *  doing the current if-else in the main method?
 *    - Function overloading?
 *      - doFormula(double, double) instead of doFormula(double, double, double)
 *  inputting an equation like "x^2+9" results in a root of "x=0", instead of "No roots in..."
 *    - See line 40
 *
 *  //d escape character - take note
 *
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a quadratic equation: ");
        Scanner sc = new Scanner(System.in);
        String sInitial = sc.nextLine();
        // remove spaces for future computations
        String equation = sInitial.replaceAll("\\s", "");
        equation = equation.toLowerCase();


        // if the equation entered is the parent quadratic function, call  the doFormula() method accordingly
        if (equation.equals("x^2"))
        {
            doFormula(1.0,0.0,0.0,equation);
            System.out.println("A: 1, B: 0, C: 0");
        }
        else
        {
            if (!checkForSymbols(equation))
            {
                // check if the last index is an 'x' or a number
                doFormula(getA(equation), getB(equation), 0.0, equation);
            }
            else
            {
                doFormula(getA(equation), getB(equation), getC(equation), equation);
                System.out.printf("A: %f, B: %f, C: %f\n", getA(equation), getB(equation), getC(equation));
                System.exit(0);
            }
        }

        System.out.println(checkForSymbols(equation));

        sc.close();
    }

    // checks to make sure if the user-inputted string has all of the symbols in needs (i.e. a '^', two 'x' variables, and two '+' or '-')
    private static boolean checkForSymbols(String s)
    {
        int symCounter = 0;
        boolean hasSymbols = false;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'x')
            {
                symCounter++;
            }

            if (s.charAt(i) == '^')
            {
                symCounter++;
            }

            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                symCounter++;
            }
        }

        // returns true if the equation has the correct number of symbols/variables (i.e. '+' or 'x')
        if (symCounter == 5)
        {
            hasSymbols = true;
        }
        return hasSymbols;
    }


    public static void doFormula(double a, double b, double c, String s)
    {
        // Quadratic Formula: x = (-b +- sqrt(b^2-4ac))/2*a
        double rootOne = 0;
        double rootTwo = 0;

        double numUnderRadicand = (Math.pow(b,2))-4*a*c;
        
        if (numUnderRadicand < 0)
        {
            // zero real roots
            System.out.println("No real roots in the equation '" + s + "'");
            System.exit(0);
        }
        else if (numUnderRadicand == 0 || b == 1)
        {
            // one real root
            rootOne = Math.sqrt(numUnderRadicand);

            System.out.println("The root of the equation '" + s + "' is: x = " + rootOne);
        }
        else if (numUnderRadicand > 0)
        {
            // two real roots
            rootOne = (-b + Math.sqrt(numUnderRadicand))/(2*a);
            rootTwo = (-b - Math.sqrt(numUnderRadicand))/(2*a);
            System.out.println("The roots in the equation '" + s + "' are: x = " + rootOne + " and: x = " + rootTwo);
        }
    }

    private static double getA(String s)
    {
        //sample equation: 6x^2+2x+4
        //                 012345678
        double a = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(0)!='x')
            {
                if (s.charAt(i) == 'x')
                {
                a = Double.parseDouble(s.substring(0, s.indexOf('x')));
                }
            } else {
                a = 1;
            }
        }
        return a;
    }

    private static double getB(String s)
    {
        double b = 0.00;
        for (int i = 0; i < s.lastIndexOf('x'); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                try
                {
                    b = Double.parseDouble(s.substring(i, s.lastIndexOf('x')));
                }
                catch (NumberFormatException e)
                {
                    b = 1;
                }
            }
        }
        return b;
    }

    private static double getC(String s)
    {
        double c = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                c = Double.parseDouble(s.substring(s.lastIndexOf('x')+1));
            }
        }
        return c;
    }
}
