/*
 * This program should take a quadratic equation
 * and solve it using the quadratic formula
 *
 * Quadratic Formula: x = (-b +-sqrt(b^2-4ac))/2
 *
 *
 * todo:
 *  - split string to chekc if there are two "x" varibles
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
        getVariables(equation);

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
        int a = 0;
        for (int i = 0; i < s.length(); i++)
        {
           if (s.charAt(i) == 'x')
           {
               a = Integer.parseInt(s.substring(0, s.indexOf('x')));
           }
        }
        System.out.println("A: " + a);
    }

    static void getB(String s)
    {
        int b = 0;
        for (int i = 0; i < s.lastIndexOf('x'); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                b = Integer.parseInt(s.substring(i, s.lastIndexOf('x')));
            }
        }
        System.out.println("B: " + b);
    }

    static void getC(String s)
    {
        int c = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                c = Integer.parseInt(s.substring(s.lastIndexOf('x')+1));
            }
        }
        System.out.println("C: " + c);
    }
}
