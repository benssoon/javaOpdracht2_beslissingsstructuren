import java.util.Scanner;
public class Ifelse {
    public static void main(String[] args) {
        Scanner whichNumber = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = whichNumber.nextInt();

    }

    public static void evOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is even");
        }
    }
}
