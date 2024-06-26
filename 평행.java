import java.util.*;

class Solution {
    // 기울기 공식
    public double getSlope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }

    public int solution(int[][] dots) {
        Set<Double> slopes = new HashSet<>();
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);

                // 같은 기울기가 있으면 평행하지 않음
                if (slopes.contains(slope)) return 1;

                slopes.add(slope);
            }
        }
        return 0;
    }
}
