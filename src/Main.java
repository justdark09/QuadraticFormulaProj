import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sInitial = sc.nextLine();
        String equation = sInitial.replaceAll("\\s", "");
        System.out.println(equation);
    }
}