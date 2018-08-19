import java.util.*;
import java.io.*;

import static java.lang.Integer.max;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;


        int index1 = 0;
        for (int first = 0; first < n; ++first) {
            if(numbers[first] > numbers[index1]) index1 = first;
        }

        int index2 = (index1 == 0) ? 1 : 0;
        for (int second = 1; second < n; ++second) {
            if(numbers[second] > numbers[index2] && second != index1) index2 = second;
        }
        return numbers[index1] * numbers[index2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = (int) scanner.nextNum();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextNum();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        long nextNum() {
            return Long.parseLong(next());
        }
    }

}