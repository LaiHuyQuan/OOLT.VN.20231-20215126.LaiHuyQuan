// Example 6: SolveEquation
import java.util.Scanner;

public class SolveEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("chon yeu cau cua ban:");
            System.out.println("1. Phuong trinh bac 1");
            System.out.println("2. Phuong trinh bac 2");
            System.out.println("3. He phuong trinh bac nhat 2 an");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua bạn: ");
            
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    giaiPtBac1();
                    break;
                case 2:
                    giaiPtBac2();
                    break;
                case 3:
                    giaiHePt();
                    break;
                case 4:
                    System.out.println("Chuong trinh ket thuc.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (option != 4);
    }

    public static void giaiPtBac1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap he so a: ");
        double a = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so b: ");
        double b = scanner.nextDouble();
        scanner.nextLine();

        if (a == 0) {
            System.out.println("Phuong trinh khong hop le. He so a khac 0.");
        } else {
            double x = -b / a;
            System.out.println("Nghiem cua phuong trinh: x = " + x);
        }
    }

    public static void giaiPtBac2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap he so a: ");
        double a = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so b: ");
        double b = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so c: ");
        double c = scanner.nextDouble();
        scanner.nextLine();

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co 2 nghiem phan biet: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Phuong trinh co nghiem kep: x = " + x);
        } else {
            System.out.println("Phuong trinh khong co nghiem thuc.");
        }
    }

    public static void giaiHePt() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap he so a11: ");
        double a11 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so a12: ");
        double a12 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so b1: ");
        double b1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so a21: ");
        double a21 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so a22: ");
        double a22 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap he so b2: ");
        double b2 = scanner.nextDouble();
        scanner.nextLine();

        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("He phuong trinh co nghiem: x1 = " + x1 + ", x2 = " + x2);
        } else if (D1 == 0 && D2 == 0) {
            System.out.println("He phuong trinh co vo so nghiem.");
        } else {
            System.out.println("He phuong trinh vo nghiem.");
        }
    }
}
