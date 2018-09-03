import java.text.DecimalFormat;
import java.util.*;

/**
 * Algorithm to solve the Fractional Knapsack problem
 */
public class FractionalKnapsack {
    private static String getOptimalValue(int capacity, int[] values, int[] weights) {
        int length = values.length;
        double value = 0;
        DecimalFormat df = new DecimalFormat("#.0000");

        // put ratios and corresponding index in map
        Map<Double, Integer> ratioMap = new HashMap<>();
        Double[] ratios = new Double[length];
        for (int i = 0; i < length; i++) {
            ratios[i] = (1.0 * values[i]) / (1.0 * weights[i]);
            ratioMap.put(ratios[i], i);
        }

        // sort list of ratios
        Arrays.sort(ratios, Collections.reverseOrder());

        // loop through ratios and get corresponding weight/value
        // add max amount possible to knapsack until full
        for (int j=0; j<length; j++) {
            if(capacity == 0) break;
            int index = ratioMap.get(ratios[j]);
            int currentWeight = weights[index];

            if (currentWeight <= capacity) currentWeight = weights[index];
            else currentWeight = capacity;

            value += currentWeight*ratios[j];
            capacity -= currentWeight;

        }

        // return formatted value
        return df.format(value);

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
