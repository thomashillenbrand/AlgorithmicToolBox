import java.util.Scanner;

public class GCDFast {
    private static int gcd(int a, int b) {
        int current_gcd = 1;
        int big, small, remainder, quotient;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }

        do {
            remainder = big%small;
            current_gcd = small;
            big = small;
            small = remainder;

        }while(remainder != 0);


        return current_gcd;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd(a, b));
    }
}
