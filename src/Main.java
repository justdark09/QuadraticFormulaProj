/*
 * This program should take a quadratic equation
 * and solve it using the quadratic formula
 *
 * Quadratic Formula: x = (-b +-sqrt(b^2-4ac))/2
 *
 *
 * todo:
 *  - Create a way to split the equation correctly,
 *  in which variables a, b, and c are identified
 *      - Take the index of "+" or "-" symbol and the
 *      next index(es) until it is not a number
 *  - indexOf, lastIndexOf methods
 *      - indexOf to get the B value
 *      - lastIndexOf to get the C value
 *
 *  //d escape character - take note
 *
 */
// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String sInitial = sc.nextLine();
        //remove spaces for future computations
        //String equation = sInitial.replaceAll("\\s", "");
        //System.out.println(getabc(equation));
        getA("6x^2+5x+4");
        getB("6x^2+5x+4");
        getC("6x^2+5x+4");
    }

    static void getA(String s)
    {
        //sample equation: 6x^2+2x+4
        //                 012345678
        int a = 0;
        for (int i = 0; i < s.length()-1; i++)
        {
           if (s.charAt(i) == 'x')
           {
               a = Integer.parseInt(s.substring(0, i));
           }
        }
        System.out.println(a);
    }

    static void getB(String s)
    {
        int b = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                b = Integer.parseInt(s.substring(i, (s.lastIndexOf('x'))));
            }
        }
        System.out.println(b);
    }

    static void getC(String s)
    {
        int c = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                c = Integer.parseInt(s.substring(s.lastIndexOf('x')+1, s.length()-1));
            }
        }
        System.out.println(c);
    }
}
