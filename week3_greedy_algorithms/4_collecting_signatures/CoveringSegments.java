import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {

    public static final int MIN_END_LIMIT = (int) Math.pow(10, 9);

    private static List<Integer> optimalPoints(List<Segment> segments) {
        //write your code here
        List points = new ArrayList();
        List<Segment> segsToRemove = new ArrayList<>();
        while(!segments.isEmpty()) {
            int minEnd = MIN_END_LIMIT;
            segsToRemove.clear();
            for (Segment s : segments) {
                if (s.end < minEnd) minEnd = s.end;
            }

            points.add(minEnd);
            for (Segment s : segments) {
                if (s.containsPoint(minEnd)) segsToRemove.add(s);
            }
            segments.removeAll(segsToRemove);
        }

        return points;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(new Segment(start, end));

        }

        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");

        }
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean containsPoint(int x) {
            return (x >= this.start && x <= this.end);
        }

        @Override
        public String toString() {
            return this.start + ", " + this.end;
        }
    }
}
 
