import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {
    private static String largestNumber(List<String> a) {
        String result = "";
        int maxDigit;
        String maxDigitString = "";
        List<String> digitsToRemove = new ArrayList<>();
        while (!a.isEmpty()) {
            digitsToRemove.clear();
            maxDigit = 0;

            for (int i = 0; i < a.size(); i++) {
                int currentInt = Integer.parseInt(a.get(i));
                if (isGreaterThanOrEqual(maxDigit, currentInt)) {
                    maxDigit = currentInt;
                    maxDigitString = Integer.toString(currentInt);

                }

            } // end for loop thru List a
            a.remove(maxDigitString);
            result += maxDigitString;
        }
        return result;
    }


    public static boolean isGreaterThanOrEqual(int maxDigit, int currentInt){
        String a = Integer.toString(maxDigit) + Integer.toString(currentInt);
        String b = Integer.toString(currentInt) +Integer.toString(maxDigit);
        if(Integer.parseInt(a) > Integer.parseInt(b)) return false;
        else return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }
        System.out.println(largestNumber(a));
        //System.out.println(isGreaterOrEqual(Integer.parseInt(a.get(0)), Integer.parseInt(a.get(1))));
    }
}

