package task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");

        try {
            long value = scanner.nextInt();
            long result = 1;

            for (long i = value; i > 0; i--) {
                result = result * i;
                System.out.println(result);
            }

        } catch (Exception exception) {
            System.out.println("Enter only number!!!");
        }

        // write your code here
    }
}
