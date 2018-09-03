import java.util.Scanner;

/**
 * Greedy algorithm to find the minimum number of "coins" (values of 1, 5, and 10)
 * a given integer m, where 1 <= m <= 1000, can be split into.
 *
 */
public class Change {
    private static int getChange(int m) {
        int terms = 0;
        while (m > 0) {

            if (m >= 10) {
                terms += m / 10;
                m = m - 10 * (m / 10);

            } else if (m >= 5) {
                terms += m / 5;
                m = m - 5 * (m / 5);

            } else {
                terms += m;
                m = 0;

            }

        }
        return terms;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

