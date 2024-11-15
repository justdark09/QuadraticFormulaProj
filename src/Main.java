/*
 * This program should take a quadratic equation
 * and solve it using the quadratic formula
 *
 * Quadratic Formula: x = (-b +-sqrt(b^2-4ac))/2
 *
 *
 * todo:
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


        if (!checkForSymbols(equation))
        {
            System.out.println("Please re-run program and enter a valid Quadratic Equation (i.e. 6x^2+4x+2). You entered: " + equation);
            System.exit(0);
        }
        getVariables(equation);
        sc.close();
    }

    // checks to make sure if the user-inputted string has all of the symbols in needs (i.e. a '^', two 'x' variables, and two '+' or '-')
    public static boolean checkForSymbols(String s)
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

        if (symCounter == 5)
        {
            hasSymbols = true;
        }

        return hasSymbols;
    }

    public static void getVariables(String s)
    {
        getA(s);
        getB(s);
        getC(s);
    }

    static void getA(String s)
    {
        //sample equation: 6x^2+2x+4
        //                 012345678
        double a = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'x')
            {
                a = Double.parseDouble(s.substring(0, s.indexOf('x')));
            }
        }
        System.out.println("A: " + a);
    }

    static void getB(String s)
    {
        double b = 0.00;
        for (int i = 0; i < s.lastIndexOf('x'); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                b = Double.parseDouble(s.substring(i, s.lastIndexOf('x')));
            }
        }
        System.out.println("B: " + b);
    }

    static void getC(String s)
    {
        double c = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                c = Double.parseDouble(s.substring(s.lastIndexOf('x')+1));
            }
        }
        System.out.println("C: " + c);
    }
}
