import java.util.*;

public class DifferentSummands {

    /**
     * Algorithm to find the max number of summands needed for a given integer n
     * @param n
     * @return List of max number of summands needed for integer n
     */
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        // base case
        if(n<=2) summands.add(n);
        // everything else
        else{
            int counter = 1;
            while(n > 0){
                if(n==counter) {
                    n = 0;
                    summands.add(counter);

                } else if (n-counter > counter){
                    n -= counter;
                    summands.add(counter);

                } else {
                    summands.add(n);
                    n=0;
                }
                counter++;

            }

        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

