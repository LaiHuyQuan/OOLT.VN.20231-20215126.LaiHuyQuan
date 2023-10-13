
// Excercise 6.5: sort array
import java.util.Scanner;
import java.util.Arrays;

public class ArraySort{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("So phan tu cua mang: ");
        int n = scanner.nextInt();

        double[] numbers = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        Arrays.sort(numbers);

        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / n;

        System.out.println("Mang sau khi sap xeo: " + Arrays.toString(numbers));
        System.out.println("Tong cua mang: " + sum);
        System.out.println("Gia tri trung binh: " + average);

    }
}
