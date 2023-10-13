
// Excercise 6.3: TriangleDisplay
import java.util.Scanner;
public class TriangleDisplay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap vao chieu cao cua tam giac: ");
        int tHeight = input .nextInt();

        for (int i = 1; i <= tHeight; i ++) {
            for (int j = 1; j <= tHeight - i; j ++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2*i - 1; k++) { 
                System.out.print("*");
            }

            System.out.println(); 
        }
    }
}
