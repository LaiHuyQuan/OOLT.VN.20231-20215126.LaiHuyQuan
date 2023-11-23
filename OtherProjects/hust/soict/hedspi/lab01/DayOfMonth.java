package hust.soict.hedspi.lab01;
// Excercise 6.4: Day of month
import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap vao so thang: ");
        String strMonth = input.nextLine();
        System.out.println("Nhap vao so nam: ");
        int iYear = input.nextInt();

        switch (strMonth) {
            case "Jan":
            case "Jan.":
            case "1":
            case "Mar.":
            case "Mar":
            case "3":
            case "May":
            case "5":
            case "July":
            case "Jul":
            case "7":
            case "Aug.":
            case "Aug":
            case "8":
            case "Oct.":
            case "Oct":
            case "10":
            case "Dec.":
            case "Dec":
            case "12":
                System.out.println("31 ngay");
                break;
            case "Apr.":
            case "Apr":
            case "4":
            case "June":
            case "Jun":
            case "6":
            case "Sept.":
            case "Sep":
            case "9":
            case "Nov.":
            case "Nov":
            case "11":
                System.out.println("30 ngay");
                break;
            case "Feb.":
            case "Feb":
            case "2":
                if (iYear % 4 != 0 || (iYear % 100 == 0 && iYear % 400 != 0)) {
                    System.out.println("28 ngay");
                } else {
                    System.out.println("29 ngay");
                }
                break;
            default:
                System.out.println("Thang khong hop le.");
        }
    }
}
