
// Example 5: calculate.java
import java.util.Scanner;

public class Calculate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        String strNum1 = sc.next();
        System.out.println("Enter the second number: ");
        String strNum2 = sc.next();
        double Num1 = Double.parseDouble(strNum1);
        double Num2 = Double.parseDouble(strNum2);
        System.out.println(Num1 + " + " + Num2 + " = " + (Num1 + Num2));
        System.out.println(Num1 + " - " + Num2 + " = " + (Num1 - Num2));
        System.out.println(Num1 + " * " + Num2 + " = " + (Num1 * Num2));
        System.out.println(Num1 + " / " + Num2 + " = " + (Num1 / Num2));
    }
}
