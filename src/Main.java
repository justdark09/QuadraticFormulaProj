/*
 * This program should take a quadratic equation
 * and solve it using the quadratic formula
 *
 * Quadratic Formula: x = (-b +-sqrt(b^2-4ac))/2
 *
 *
 * todo:
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String sInitial = sc.nextLine();
        //remove spaces for future computations
        //String equation = sInitial.replaceAll("\\s", "");
        //System.out.println(getabc(equation));
        System.out.println(getabc("556x^2+2x+4"));
    }

    static int getabc(String k)
    {
        //sample equation: 6x^2+2x+4
        //                 012345678
        int a=0;
        String s = k.toLowerCase();
        for (int i = 0; i < s.length()-1; i++)
        {
            char temp = s.charAt(i);
            switch (temp)
            {
                case 'x':
                    a = Integer.parseInt(s.substring(0, i));
                break;


                default: continue;
            }
            return a;
        }
        return a;

    }
}